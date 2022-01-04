package k5.goodsjoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.Business;
import k5.goodsjoc.service.BusinessService;

@Controller
@RequestMapping(value = "/basic_management/business")
public class BusinessController {
	
	private BusinessService businessService;
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@GetMapping("/businessList")
	public String businessList(Model model) {
		System.out.println("페이지: 거래처 관리 ");
		System.out.println("경로: basic_management/business/businessList(GET방식 성공) ");
		
		List<Business> businessList = businessService.getBusinessList();
		model.addAttribute("businessList");
		
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
