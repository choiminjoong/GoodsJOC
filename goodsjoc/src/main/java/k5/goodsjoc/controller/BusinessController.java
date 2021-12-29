package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/basic_management/business")
public class BusinessController {

	@GetMapping("/businessList")
	public String businessList() {

		return "basic_management/business/businessList";
	}

	@GetMapping("/businessInsert")
	public String businessInsert() {
		
		return "basic_management/business/businessInsert";
	}
}
