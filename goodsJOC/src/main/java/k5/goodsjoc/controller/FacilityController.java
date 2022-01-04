package k5.goodsjoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.Showcase;
import k5.goodsjoc.service.FacilityService;

@Controller
@RequestMapping(value = "/basic_management/facility")
public class FacilityController {
	
	private FacilityService facilityService;
	public FacilityController(FacilityService facilityService) {
		this.facilityService = facilityService;
	}
	
	
	@GetMapping("/facilityInsert")
	public String facilityInsert() {
		
		return "basic_management/facility/facilityInsert";
	}

	@GetMapping("/facilityList")
	public String facilityList(Model model) {
		System.out.println("페이지: 시설 관리 ");
		System.out.println("경로: basic_management/facility/facilityList(GET방식 성공) ");
		
		List<Showcase> showcaseList = facilityService.getShowcaseList();
		model.addAttribute("showcaseList",showcaseList);
		System.out.println("완료");
		
		return "basic_management/facility/facilityList";
	}
	
	
	
	
}
