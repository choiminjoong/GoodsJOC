package k5.goodsjoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.ViewOrder;
import k5.goodsjoc.dto.Warehousing;
import k5.goodsjoc.service.WarehousingService;

@Controller
@RequestMapping(value="/stock_management/warehousing")
public class WarehousingController {

	private WarehousingService warehousingService;
	public WarehousingController(WarehousingService warehousingService) {
		this.warehousingService = warehousingService;
	}
	
	@GetMapping("/warehousingInsert")
	public String warehousingInsert() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingInsert(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingInsert";
	}

	@GetMapping("/warehousingList")
	public String warehousingList(Model model) {
		System.out.println("페이지: 입고 조회");
		System.out.println("경로: stock_management/warehousing/warehousingList(GET방식 성공) ");
		List<Warehousing> warehousingList = warehousingService.getWarehousingList();
		model.addAttribute("warehousingList",warehousingList);		
		
		
		
		return "stock_management/warehousing/warehousingList";
	}
	
	@GetMapping("/warehousingUpdate")
	public String warehousingUpdate() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingUpdate(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingUpdate";
	}
}
