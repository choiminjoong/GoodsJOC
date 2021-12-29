package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/basic_management/facility")
public class FacilityController {
	
	@GetMapping("/facilityInsert")
	public String facilityInsert() {
		
		return "basic_management/facility/facilityInsert";
	}

	@GetMapping("/facilityList")
	public String facilityList() {
		
		return "basic_management/facility/facilityList";
	}
	
	
	
	
}
