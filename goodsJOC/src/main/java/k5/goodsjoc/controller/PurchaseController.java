package k5.goodsjoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.dto.Purchase;
import k5.goodsjoc.service.OrderService;
import k5.goodsjoc.service.PurchaseService;

@Controller
@RequestMapping(value="/trade_management/purchase")
public class PurchaseController {
	private PurchaseService purchaseService;
	private OrderService orderService;
	public PurchaseController(PurchaseService purchaseService, OrderService orderService) {
		this.purchaseService = purchaseService;
		this.orderService = orderService;
	}
	
	@PostMapping("/searchPurchaseList")
	public String searchPurchaseList(@RequestParam(value="businessCode", required=false) String businessCode,
									 @RequestParam(value="startDate", required=false) String startDate,
									 @RequestParam(value="endDate", required=false) String endDate,
									 @RequestParam(value="id", required=false) String id,
									 @RequestParam(value="minPrice", required=false) String minPrice,
									 @RequestParam(value="maxPrice", required=false) String maxPrice,
									 @RequestParam(value="state", required=false) String state,
									 @RequestParam(value="orderNum", required=false) String orderNum,
									 HttpServletRequest request, Model model) {
		//로그인 기준 마트코드
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		System.out.println("로그인한 유저기준 마트고유코드: " + sessionMartCode);
		
		//조회할 변수들을 담은 맵
		Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("martCode", sessionMartCode);
			paramMap.put("businessCode", businessCode);
			paramMap.put("startDate", startDate);
			paramMap.put("endDate", endDate);
			paramMap.put("id", id);
			paramMap.put("minPrice", minPrice);
			paramMap.put("maxPrice", maxPrice);
			paramMap.put("state", state);
			paramMap.put("orderNum", orderNum);
		//매입금액 및 건수 조회 
		List<Map<String, Object>> purchaseDatePrice = orderService.purchaseDatePrice(sessionMartCode);
		model.addAttribute("purchaseDatePrice", purchaseDatePrice);	
		System.out.println(purchaseDatePrice);
		
		List<Order> purchaseList = orderService.searchPurchaseList(paramMap);
		model.addAttribute("purchaseList", purchaseList);	
		
		//거래명세서 조회
		List<Purchase> purchaseDetailList = purchaseService.getPurchaseDetailList(sessionMartCode);
		model.addAttribute("purchaseDetailList", purchaseDetailList);	


		return "trade_management/purchase/purchaseList";
	}
	
	@PostMapping("/purchaseDetailList")
	@ResponseBody
	public List<OrderDetail> purchaseDetailList(@RequestParam(value="orderCode", required = false) String orderCode) {
		System.out.println("거래명세서 상세정보 Ajax");
		List<OrderDetail> result = orderService.getPurchaseDetailList(orderCode);
		
		return result;
	}
	
	@PostMapping("/purchaseInfo")
	@ResponseBody
	public Order purchaseInfo(@RequestParam(value="orderCode", required = false) String orderCode){
		System.out.println("거래명세서 정보 Ajax");
		Order result = orderService.getPurchaseInfoByOrderCode(orderCode);
		
		return result;
	}
	//매입 검색(오대성)
	@PostMapping("/PurchaseList")
	public String PurchaseList(HttpServletRequest request,
								@RequestParam(value="searchKey", required = false) String searchKey,
							   @RequestParam(value="searchValue", required = false) String searchValue,
							   @RequestParam(value="startDt", required = false) String startDt,
							   @RequestParam(value="endDt", required = false) String endDt,
							   Model model) {
		
		System.out.println(searchKey);
		System.out.println(searchValue);
		
	HttpSession session = request.getSession();
	String sessionMartCode = (String) session.getAttribute("SMARTCODE");
	
	if(searchKey != null && "goodsName".equals(searchKey)) {
		searchKey = "goodsName";
	}else if(searchKey != null && "businessName".equals(searchKey)) {
		searchKey = "businessName";	
	}else if(searchKey != null && "purchaseDate".equals(searchKey)) {
		searchKey = "purchaseDate";	
	}
	// 검색키 검색어를 통해서 매입 조회
		
	List<Purchase> purchaseList = purchaseService.getPurchaseBySearchKey(searchKey, searchValue, sessionMartCode, startDt, endDt);
	
	// 조회된 입고 목록 model에 값을 저장
	model.addAttribute("title", "매입조회");
	model.addAttribute("purchaseList", purchaseList);
		
	return "trade_management/purchase/purchaseList";	
	}
	
	//매입관리 > 매입조회 (오대성)
	@GetMapping("/purchaseList")
	public String purchaseList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 매입 조회");
		System.out.println("경로: trade_management/purchase/purchaseList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Map<String, Object>> purchaseDatePrice = orderService.purchaseDatePrice(sessionMartCode);
		model.addAttribute("purchaseDatePrice", purchaseDatePrice);	
		System.out.println(purchaseDatePrice);
		
		List<Order> purchaseList = orderService.getOrderPurchaseList(sessionMartCode);
		model.addAttribute("purchaseList", purchaseList);	
		
		//거래명세서 조회
		List<Purchase> purchaseDetailList = purchaseService.getPurchaseDetailList(sessionMartCode);
		model.addAttribute("purchaseDetailList", purchaseDetailList);
		
		return "trade_management/purchase/purchaseList";
	}

}
