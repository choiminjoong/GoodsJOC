package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock_management/display")
public class DisplayController {
	
	@GetMapping("displayInsert")
	public String displayInsert() {
		System.out.println("페이지: 재고 이동(진열) ");
		System.out.println("경로: stock_management/display/displayInsert(GET방식 성공) ");
		
		return "/stock_management/display/displayInsert";
	}

	@GetMapping("displayUpdate")
	public String displayUpdate() {
		System.out.println("페이지: 재고 이동 조회 ");
		System.out.println("경로: stock_management/display/displayUpdate(GET방식 성공) ");
		
		return "/stock_management/display/displayUpdate";
	}
	
	
}
