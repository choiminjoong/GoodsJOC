package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/trade_management/sales")
public class SalesController {
	
	@GetMapping("/salesInsert")
	public String salesInsert() {
		System.out.println("페이지: 매출 등록");
		System.out.println("경로: trade_management/sales/salesInsert(GET방식 성공) ");
		
		return "trade_management/sales/salesInsert";
  }
	
	@GetMapping("/salesList")
	public String salesList() {
		System.out.println("페이지: 매출 조회");
		System.out.println("경로: trade_management/sales/salesList(GET방식 성공) ");
		
		return "trade_management/sales/salesList";
	}
	@GetMapping("/purchaseList1")
	public String purchaseList1() {
		System.out.println("페이지: 매출 조회");
		System.out.println("경로: trade_management/sales/purchaseList1(GET방식 성공) ");
		
		return "trade_management/sales/purchaseList1";
	}
}
