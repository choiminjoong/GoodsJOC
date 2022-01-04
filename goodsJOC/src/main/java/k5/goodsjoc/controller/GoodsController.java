package k5.goodsjoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.service.GoodsService;

@Controller
@RequestMapping(value = "/product_management/goods")
public class GoodsController {
	
	private GoodsService goodsService;
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@GetMapping("/goodsCate")
	public String goodsCate(Model model) {
		System.out.println("페이지: 상품 카테고리 ");
		System.out.println("경로: product_management/goods/goodsCate(GET방식 성공) ");
		
		List<GoodsCate> goodsCateList = goodsService.getGoodsCateList();
		model.addAttribute("goodsCateList", goodsCateList);
		System.out.println("완료");
		
		return "product_management/goods/goodsCate";
	}
	
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		System.out.println("페이지: 상품 등록 ");
		System.out.println("경로: product_management/goods/goodsInsert(GET방식 성공) ");
		
		return "product_management/goods/goodsInsert";
	}
	@GetMapping("/goodsList")
	public String goodsList() {
		System.out.println("페이지: 상품 조회 ");
		System.out.println("경로: product_management/goods/goodsList(GET방식 성공) ");
		
		return "product_management/goods/goodsList";
	}
}
