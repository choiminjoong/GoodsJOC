package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
	
	@GetMapping("/facilityInsert")
	public String whInsert() {
		
		return "facility/facilityInsert";
	}

	@GetMapping("/facilityList")
	public String facilityList() {
		
		return "facility/facilityList";
	}
	
	
	
	
}
