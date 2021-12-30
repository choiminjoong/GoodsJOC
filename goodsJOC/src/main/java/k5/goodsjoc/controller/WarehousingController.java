package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/stock_management/warehousing")
public class WarehousingController {

	@GetMapping("/warehousingInsert")
	public String warehousingInsert() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingInsert(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingInsert";
	}

	@GetMapping("/warehousingList")
	public String warehousingList() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingList(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingList";
	}
	
	@GetMapping("/warehousingUpdate")
	public String warehousingUpdate() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingUpdate(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingUpdate";
	}
}
