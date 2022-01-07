package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.service.GoodsService;

@Controller
@RequestMapping(value = "/product_management/goods")
public class GoodsController {
	
	private GoodsService goodsService;
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@GetMapping("/goodsUpdate")
	public String goodsUpdate() {
		System.out.println("페이지: 상품 수정");
		System.out.println("경로: product_management/goods/goodsUpdate(GET방식 성공) ");
		
		return "product_management/goods/goodsUpdate";
	}
	
	@GetMapping("/goodsCate")
	public String goodsCate(HttpServletRequest request, Model model) {
		System.out.println("페이지: 상품 카테고리 ");
		System.out.println("경로: product_management/goods/goodsCate(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<GoodsCate> goodsCateList = goodsService.getGoodsCateList(sessionMartCode);
		model.addAttribute("goodsCateList", goodsCateList);
		System.out.println("model에 담긴 상품카테고리: " + model);
		
		return "product_management/goods/goodsCate";
	}
	
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		System.out.println("페이지: 상품 등록 ");
		System.out.println("경로: product_management/goods/goodsInsert(GET방식 성공) ");
		
		return "product_management/goods/goodsInsert";
	}
	@GetMapping("/goodsList")
	public String goodsList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 상품 조회 ");
		System.out.println("경로: product_management/goods/goodsList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<GoodsCate> goodsCateList = goodsService.getGoodsCateList(sessionMartCode);
		model.addAttribute("goodsCateList", goodsCateList);
		System.out.println("model에 담긴 상품카테고리: " + model);
		
		List<Goods> goodsList = goodsService.getGoodsList(sessionMartCode);
		model.addAttribute("goodsList", goodsList);
		System.out.println("model에 담긴 상품리스트: " + model);
		
		
		return "product_management/goods/goodsList";
	}
}
