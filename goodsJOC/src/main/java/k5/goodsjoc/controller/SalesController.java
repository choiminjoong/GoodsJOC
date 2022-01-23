package k5.goodsjoc.controller;

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

import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.service.SalesService;

@Controller
@RequestMapping(value="/trade_management/sales")
public class SalesController {
	
	private SalesService salesService;
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@PostMapping("/salesDetialInfo")
	@ResponseBody
	public List<OrderDetail> salesDetialInfo(@RequestParam(value="orderCode", required=false) String orderCode){
		
		
		return null;
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
	

