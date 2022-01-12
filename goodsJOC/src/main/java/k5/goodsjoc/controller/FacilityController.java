package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.Shelf;
import k5.goodsjoc.dto.Showcase;
import k5.goodsjoc.dto.Warehouse;
import k5.goodsjoc.service.FacilityService;

@Controller
@RequestMapping(value = "/basic_management/facility")
public class FacilityController {
	
	private FacilityService facilityService;
	public FacilityController(FacilityService facilityService) {
		this.facilityService = facilityService;
	}
	//창고 등록
	@PostMapping("/warehouseInsert")
	public String warehouseInsert(Warehouse warehouse) {
		System.out.println("페이지: 창고등록 처리");
		System.out.println("경로: basic_management/facility/warehouseInsert(Post방식 성공) ");
		System.out.println("화면에서 받은 창고 정보 : "+ warehouse);
		
		facilityService.warehouseInsert(warehouse);
		
		
		return "redirect:/basic_management/facility/facilityList";
		
	}
	
	@PostMapping("/shelfInsert")
	public String shelfInsert(Shelf shelf) {
		System.out.println("페이지: 창고진열대 등록 처리");
		System.out.println("경로: basic_management/facility/shelfInsert(Post방식 성공) ");
		System.out.println("화면에서 받은 창고 진열대 정보 : "+ shelf);
		facilityService.shelfInsert(shelf);
		
		return "redirect:/basic_management/facility/facilityList";
		
	}
	
	@PostMapping("/showcaseInsert")
	public String showcaseInsert(Showcase showcase) {
		System.out.println("페이지: 판매진열대 등록 처리");
		System.out.println("경로: basic_management/facility/showcaseInsert(Post방식 성공) ");
		System.out.println("화면에서 받은 판매 진열대 정보 : "+ showcase);
		
		facilityService.showcaseInsert(showcase);
		
		
		return "redirect:/basic_management/facility/facilityList";
		
	}
	
	
	
	

	@GetMapping("/facilityList")
	public String facilityList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 시설 관리 ");
		System.out.println("경로: basic_management/facility/facilityList(GET방식 성공) ");

		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Showcase> showcaseList = facilityService.getShowcaseList(sessionMartCode);
		model.addAttribute("showcaseList",showcaseList);
		System.out.println("model에 담긴 showcaseList: " + showcaseList);
		
		List<Warehouse> warehouseList = facilityService.getWarehouseList(sessionMartCode);
		model.addAttribute("warehouseList", warehouseList);
		System.out.println("model에 담긴 warehouseList: " + warehouseList);
		
		List<Warehouse> warehouseNameList= facilityService.getWarehouseListByMartCode(sessionMartCode);
		model.addAttribute("warehouseNameList", warehouseNameList);
		System.out.println("model에 담긴 warehouseNameList: " + warehouseNameList);
		
		return "basic_management/facility/facilityList";
	}
	
	
	
	
	
}
