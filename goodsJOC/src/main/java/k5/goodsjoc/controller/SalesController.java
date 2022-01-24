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

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.dto.SalesDetail;
import k5.goodsjoc.service.SalesService;

@Controller
@RequestMapping(value="/trade_management/sales")
public class SalesController {
	
	private SalesService salesService;
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	}
	@PostMapping("/searchSalesList")
	public String getSearchSalesList(@RequestParam(value="id", required=false) String id,
									 @RequestParam(value="minPrice", required=false) String minPrice,
									 @RequestParam(value="maxPrice", required=false) String maxPrice,
									 @RequestParam(value="canselCheck", required=false) String canselCheck,
									 @RequestParam(value="startDate", required=false) String startDate,
									 @RequestParam(value="endDate", required=false) String endDate,
									 @RequestParam(value="receiptNum", required=false) String receiptNum,
									 HttpServletRequest request, Model model) {
		//로그인 기준 마트코드
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		System.out.println("로그인한 유저기준 마트고유코드: " + sessionMartCode);
		
		//조회할 변수들을 담은 맵
		Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("martCode", sessionMartCode);
			paramMap.put("id", id);
			paramMap.put("minPrice", minPrice);
			paramMap.put("maxPrice", maxPrice);
			paramMap.put("canselCheck", canselCheck);
			paramMap.put("startDate", startDate);
			paramMap.put("endDate", endDate);
			paramMap.put("receiptNum", receiptNum);
		//금액정보
		List<Map<String, Object>> salesTotalInfo = salesService.getSalesTotalInfo(sessionMartCode);
		model.addAttribute("salesTotalInfo", salesTotalInfo);
		
		List<Sales> salesList = salesService.getSearchSalesList(paramMap);
		model.addAttribute("salesList", salesList);
			
		return "trade_management/sales/salesList";
	}
	
	@PostMapping("/receiptCanselAction")
	public String receiptCanselAction(@RequestParam(value="salesCode", required=false) String salesCode, HttpServletRequest request) {
		System.out.println("페이지: 영수증취소");
		System.out.println("경로: trade_management/sales/receiptCanselAction(POST방식 성공) ");
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("SID");
		
		salesService.receiptCanselAction(sessionId, salesCode);
		
		return "redirect:/trade_management/sales/salesList";
	}
	
	//판매취소 정보
	@PostMapping("/salesCanselInfo")
	@ResponseBody
	public Sales salesCanselInfo(@RequestParam(value="salesCode", required=false) String salesCode){
		System.out.println("페이지: 영수증 상세");
		System.out.println("경로: trade_management/sales/salesInsert(POST방식 성공) ");
		
		Sales result = salesService.getSalesCanselInfo(salesCode);
		
		return result;
	}
	
	//판매정보 상세(영수증)
	@PostMapping("/salesDetailInfo")
	@ResponseBody
	public List<SalesDetail> salesDetailInfo(@RequestParam(value="salesCode", required=false) String salesCode){
		System.out.println("페이지: 영수증 상세");
		System.out.println("경로: trade_management/sales/salesInsert(POST방식 성공) ");
		
		List<SalesDetail> result = salesService.getSalesDetailList(salesCode);
		
		return result;
	}
	
	//매출관리 > 매출등록 (정도혜)
	@GetMapping("/salesInsert")
	public String salesInsert() {
		System.out.println("페이지: 매출 등록");
		System.out.println("경로: trade_management/sales/salesInsert(GET방식 성공) ");
		
		return "trade_management/sales/salesInsert";
	}
	
	@PostMapping("/salesInsert")
	public String salesInsert(Sales sales) {
		System.out.println("페이지: 매출등록");
		System.out.println("경로: trade_management/sales/salesInsert(POST방식 성공) ");
		System.out.println("화면에서 받은 매출 정보: " + sales);
		
		salesService.salesInsert(sales);
		
		return "redirect:/trade_management/sales/salesList";
		
	}
	
	//매출관리 > 매출전체조회 (정도혜)
	@GetMapping("/salesList")
	public String salesList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 매출 조회");
		System.out.println("경로: trade_management/sales/salesList(GET방식 성공) ");
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Map<String, Object>> salesTotalInfo = salesService.getSalesTotalInfo(sessionMartCode);
		model.addAttribute("salesTotalInfo", salesTotalInfo);
		
		List<Sales> salesList = salesService.getSalesList(sessionMartCode);
		model.addAttribute("salesList", salesList);
		
		return "trade_management/sales/salesList";
	}
	
	@GetMapping("/purchaseList1")
	public String purchaseList1() {
		System.out.println("페이지: 매출 조회");
		System.out.println("경로: trade_management/sales/purchaseList1(GET방식 성공) ");
		
		return "trade_management/sales/purchaseList1";
	}
	
	//매출관리 > 조건검색 (정도혜)
	@PostMapping("/salesList")
	public String getSearchBusinessList(
			 @RequestParam(value="searchKey", required = false) String searchKey
			,@RequestParam(value="searchValue", required = false) String searchValue
			,@RequestParam(value="startDt", required = false) String startDt
			,@RequestParam(value="endDt", required = false) String endDt
			,@RequestParam(value="searchCancell", required = false) String searchCancell
			,Model model) {
		System.out.println(searchKey);
		System.out.println(searchValue);
		System.out.println(searchCancell);
		
		if(searchKey != null && "receiptNum".equals(searchKey)) {
			searchKey = "receiptNum";
		}else if(searchKey != null && "salesTotalPrice".equals(searchKey)) {
			searchKey = "salesTotalPrice";
		}else  {
			searchKey = "casnselStaff";
		}
		// 검색키 검색어를 통해서 회원목록 조회
		List<Sales> salesList = salesService.getSalesListBySearchKey(searchKey, searchValue, startDt, endDt);
		
		// 조회된 회원목록 model에 값을 저장
		model.addAttribute("title", "거래처목록조회");
		model.addAttribute("salesList", salesList);
		
		return "product_management/order/orderList";
	}
	
	//상품선택 모달 Ajax (정도혜)
	@PostMapping("/searchGoodsModal")
	@ResponseBody
	public List<Map<String, Object>> searchGoodsModal(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Map<String, Object>> goodsModal = salesService.getGoodsList(sessionMartCode);
		
		return goodsModal;
	}	
	
	//매출등록후 매출리스트로 전환
	@PostMapping("/salesInsertAction")
	public String salesInsertAction(Sales sales) {
		System.out.println("매출등록처리 POST방식:");
		System.out.println("입력받은 데이터: " + sales);
		salesService.addsalesAction(sales);
		
		return "redirect:/trade_management/sales/salesList";
	}
}		