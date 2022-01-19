package k5.goodsjoc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.service.DisplayService;

@Controller
@RequestMapping("/stock_management/display")
public class DisplayController {
	private DisplayService displayService;
	public DisplayController(DisplayService displayService) {
		this.displayService = displayService;
	}
	
	
	@GetMapping("displayInsert")
	public String displayInsert() {
		System.out.println("페이지: 재고 이동(진열) ");
		System.out.println("경로: stock_management/display/displayInsert(GET방식 성공) ");
		
		return "/stock_management/display/displayInsert";
	}

	@GetMapping("displayUpdate")
	public String displayUpdate() {
		System.out.println("페이지: 재고 이동 정보 수정 ");
		System.out.println("경로: stock_management/display/displayUpdate(GET방식 성공) ");
		
		return "/stock_management/display/displayUpdate";
	}
	
	@GetMapping("displayList")
	public String displayList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 재고 이동 조회 ");
		System.out.println("경로: stock_management/display/displayList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Map<String, Object>> displayList = displayService.getDisplayList(sessionMartCode);
		model.addAttribute("displayList", displayList);
		
		return "/stock_management/display/displayList";
	}
	
	
}
