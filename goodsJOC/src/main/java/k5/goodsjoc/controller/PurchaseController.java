package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k5.goodsjoc.dto.Purchase;
import k5.goodsjoc.service.PurchaseService;

@Controller
@RequestMapping(value="/trade_management/purchase")
public class PurchaseController {
	
	private PurchaseService purchaseService;
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
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
		
		List<Purchase> purchaseList = purchaseService.getPurchaseList(sessionMartCode);
		model.addAttribute("purchaseList", purchaseList);
		
		//거래명세서 조회
		List<Purchase> purchaseDetailList = purchaseService.getPurchaseDetailList(sessionMartCode);
		model.addAttribute("purchaseDetailList", purchaseDetailList);
		
		return "trade_management/purchase/purchaseList";
	}
	//거래명세서 조회
	/*
	 * @GetMapping("/	") public String purchaseDetailList(HttpServletRequest
	 * request, Model model) { System.out.println("페이지: 매입 거래명세서 조회"); System.out.
	 * println("경로: trade_management/purchase/purchaseDetailList(GET방식 성공) ");
	 * 
	 * HttpSession session = request.getSession(); String sessionMartCode = (String)
	 * session.getAttribute("SMARTCODE");
	 * 
	 * List<Purchase> purchaseDetailList =
	 * purchaseService.getPurchaseDetailList(sessionMartCode);
	 * model.addAttribute("purchaseDetailList", purchaseDetailList);
	 * 
	 * return "trade_management/purchase/purchaseList"; }
	 */
}
