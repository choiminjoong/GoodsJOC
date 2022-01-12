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
import org.springframework.web.bind.annotation.ResponseBody;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.dto.PurchasePrice;
import k5.goodsjoc.dto.SalesPrice;
import k5.goodsjoc.service.GoodsService;

@Controller
@RequestMapping(value = "/product_management/goods")
public class GoodsController {
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	private GoodsService goodsService;
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	//상품등록후 상품리스트로 전환
	@PostMapping("/goodsInsertAction")
	public String goodsInsertAction(Goods goods) {
		System.out.println("상품등록처리 POST방식:");
		System.out.println("입력받은 데이터: " + goods);
		goodsService.addGoodsAction(goods);
		
		return "redirect:/product_management/goods/goodsList";
	}
	
	
	@PostMapping("/searchGoodsCate")
	public String searchGoodsCate(HttpServletRequest request, Model model,
								  @RequestParam(value="searchCate", required=false)String searchCate) {
		System.out.println("화면에서 받은 카테고리 조건 입력값: " + searchCate);
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<GoodsCate> goodsCateList = goodsService.getSearchGoodsCateList(searchCate, sessionMartCode);
		
		model.addAttribute("goodsCateList", goodsCateList);
		System.out.println("model에 담긴 상품카테고리: " + model);
		
		return "product_management/goods/goodsCate";
	}
	
	//상품관리 > 등록페이지 바코드 사용여부확인 Ajax (최민중)
	@PostMapping("/barcodeCheck")
	@ResponseBody
	public boolean barcodeCheck(@RequestParam(value="barcode", required=false) String barcode) {
		System.out.println("바코드 사용여부 확인 버튼Ajax");
		System.out.println("등록폼에서 확인할 바코드: " + barcode);
		
		boolean checkResult = false;
		int check = goodsService.goodsCheckByBarcode(barcode);
		if(check > 0) checkResult = true;
		
		return checkResult;
	}
	
	
	//상품관리 내 상품카테고리 선택 모달 Ajax (최민중)
	@PostMapping("/searchCategoryModal")
	@ResponseBody
	public List<Map<String, Object>> searchCategoryModal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Map<String, Object>> categoryModal = goodsService.getCategoryList(sessionMartCode);
		
		return categoryModal;
	}
	
	//상품관리 > 조회 > 단가수정작업 (최민중)
	@PostMapping("/goodsPriceUpdate")
	public String goodsPriceUpdate(HttpServletRequest request, Goods goods, Model model) {
		System.out.println("페이지: 상품단가 변경액션 ");
		System.out.println("경로: product_management/goods/goodsPriceUpdate(Post방식 성공) ");
		System.out.println("리스트에서 받은 바코드: " + goods.getBarcode());
		System.out.println("수정할 판매단가: " + goods.getSalesPrice());
		String barcode = goods.getBarcode();
		String salesPrice = goods.getSalesPrice();

		if(salesPrice != null && salesPrice != "".toString()) {
			//판매가 수정
			int updateSucess = goodsService.updateGoodsPrice(barcode, salesPrice);
			System.out.println("판매단가 수정 완료 ");
			
			if(updateSucess > 0) {
				System.out.println("판매단가 기록");
				//판매가 변경기록을 위한  Insert 매개변수 ID, MARTCODE
				HttpSession session = request.getSession();
				String sessionID = (String) session.getAttribute("SID");
				String sessionMartCode = (String) session.getAttribute("SMARTCODE");
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("martCode", sessionMartCode);
				paramMap.put("ID", sessionID);
				paramMap.put("barcode", barcode);
				paramMap.put("salesPrice", salesPrice);
				
				//판매가 변경 기록하기
				goodsService.addSalesPrice(paramMap);
				
				return "redirect:/product_management/goods/goodsList";
			}
		}
		
		return "system_management/error/error500";
	}
	
	//상품관리 > 조회 > 단가조정 (최민중)
	@GetMapping("/goodsPriceList")
	public String goodsPriceList(@RequestParam(value="barcode", required= false) String barcode, Model model) {
		System.out.println("페이지: 상품단가 조정 ");
		System.out.println("경로: product_management/goods/goodsPriceList(GET방식 성공)");
		System.out.println("리스트에서 받은 바코드: " + barcode);
		
		Goods goodsInfo = goodsService.getGoodsInfoByBarcode(barcode);
		model.addAttribute("goodsInfo", goodsInfo);
		
		List<PurchasePrice> purchasePriceList = goodsService.getPurchasePriceListByBarcode(barcode);
		List<SalesPrice> salesPriceList = goodsService.getSalesPriceListByBarcode(barcode);
		model.addAttribute("purchasePriceList", purchasePriceList);
		model.addAttribute("salesPriceList", salesPriceList);
		
		return "product_management/goods/goodsPriceList";
	}
	
	//상품정보 수정 페이지 (미완성)
	@GetMapping("/goodsUpdate")
	public String goodsUpdate(@RequestParam(value="barcode", required= false) String barcode, Model model) {
		System.out.println("barcode: " + barcode);
		
		/* Goods goodsInfo = goodsService.getGoodsInfoByBarcode(); */
		/* model.addAttribute("goodsInfo", goodsInfo); */
		
		return "product_management/goods/goodsUpdate";
	}
	
	//상품관리 > 카테고리 페이지 (최민중)
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
	
	//상품관리 > 등록 페이지(최민중)
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		System.out.println("페이지: 상품 등록 ");
		System.out.println("경로: product_management/goods/goodsInsert(GET방식 성공) ");
		
		return "product_management/goods/goodsInsert";
	}	
	
	//상품관리 > 조회 > 조건검색하기 (최민중)
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
	
	//상품관리 > 조회 페이지 (최민중)
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
