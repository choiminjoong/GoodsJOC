package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/basic_management/business")
public class BusinessController {

	@GetMapping("/businessList")
	public String businessList() {
		System.out.println("페이지: 거래처 관리 ");
		System.out.println("경로: basic_management/business/businessList(GET방식 성공) ");
		
		return "basic_management/business/businessList";
	}

	@GetMapping("/businessInsert")
	public String businessInsert() {
		System.out.println("페이지: 거래처 등록 ");
		System.out.println("경로: basic_management/business/businessInsert(GET방식 성공) ");		
		
		
		return "basic_management/business/businessInsert";
	}

	@GetMapping("/businessUpdate")
	public String businessUpdate() {
		System.out.println("페이지: 거래처 수정 ");
		System.out.println("경로: basic_management/business/businessUpdate(GET방식 성공) ");		
		
		return "basic_management/business/businessUpdate";
	}
}
