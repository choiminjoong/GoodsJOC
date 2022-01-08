package k5.goodsjoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.service.GoodsService;

@Controller
@RequestMapping(value = "/product_management/goods")
public class GoodsController {

	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private GoodsService goodsService;
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@GetMapping("/goodsUpdate")
	public String goodsUpdate(@RequestParam(value="barcode", required= false) String barcode, Model model) {
		System.out.println("barcode: " + barcode);
		
		/* Goods goodsInfo = goodsService.getGoodsInfoByBarcode(); */
		/* model.addAttribute("goodsInfo", goodsInfo); */
		
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
	
	@PostMapping("/goodsList")
	public String goodsList(@RequestParam(value="searchCategory", required=false) String searchCategory,
							@RequestParam(value="minPurchasePrice", required=false) String minPurchasePrice,
							@RequestParam(value="maxPurchasePrice", required=false) String maxPurchasePrice,
							@RequestParam(value="searchTaxType", required=false) String searchTaxType,
							@RequestParam(value="minSalesPrice", required=false) String minSalesPrice,
							@RequestParam(value="maxSalesPrice", required=false) String maxSalesPrice,
							@RequestParam(value="searchGoodsName", required=false) String searchGoodsName,
							HttpServletRequest request, Model model) {
		System.out.println("페이지: 상품 조건검색");
		System.out.println("경로: product_management/goods/goodsList(POST방식 성공)");
		System.out.println("카테고리조건: " + searchCategory);
		System.out.println("매입가시작조건: " + minPurchasePrice);
		System.out.println("매입가끝조건: " + maxPurchasePrice);
		System.out.println("세금유형조건: " + searchTaxType);
		System.out.println("판매가시작조건: " + minSalesPrice);
		System.out.println("판매가끝조건: " + maxSalesPrice);
		System.out.println("상품이름조건: " + searchGoodsName);
		
		//로그인 기준 마트코드
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		System.out.println("로그인한 유저기준 마트고유코드: " + sessionMartCode);

		//카테고리 목록
		List<GoodsCate> goodsCateList = goodsService.getGoodsCateList(sessionMartCode);
		model.addAttribute("goodsCateList", goodsCateList);
		System.out.println("model에 담긴 상품카테고리: " + model);
		
		//조회할 변수들을 담은 맵
		Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("searchCategory", searchCategory);
			paramMap.put("minPurchasePrice", Integer.parseInt(minPurchasePrice));
			paramMap.put("maxPurchasePrice", Integer.parseInt(maxPurchasePrice));
			paramMap.put("searchTaxType", searchTaxType);
			paramMap.put("minSalesPrice", Integer.parseInt(minSalesPrice));
			paramMap.put("maxSalesPrice", Integer.parseInt(maxSalesPrice));
			paramMap.put("searchGoodsName", searchGoodsName);
			paramMap.put("martCode", sessionMartCode);
		System.out.println("paramMap: " + paramMap);
		
		List<Goods> goodsList = goodsService.getSearchGoodsList(paramMap);
		model.addAttribute("goodsList", goodsList);
		System.out.println("모델에 담긴 goodsList: " + model);	
		
		return "product_management/goods/goodsList";
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
