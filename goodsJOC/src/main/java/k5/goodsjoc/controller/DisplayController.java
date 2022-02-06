package k5.goodsjoc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//재고이동 검색(오대성)
	@PostMapping("/searchDisplayList")
	public String DisplayList(HttpServletRequest request,
								@RequestParam(value="searchKey", required = false) String searchKey,
							   @RequestParam(value="searchValue", required = false) String searchValue,
							   @RequestParam(value="startDt", required = false) String startDt,
							   @RequestParam(value="endDt", required = false) String endDt,
							   Model model) {
		
		System.out.println(searchKey);
		System.out.println(searchValue);
		
	HttpSession session = request.getSession();
	String sessionMartCode = (String) session.getAttribute("SMARTCODE");
	
	if(searchKey != null && "goodsName".equals(searchKey)) {
		searchKey = "goodsName";
	}else if(searchKey != null && "userName".equals(searchKey)) {
		searchKey = "userName";	
	}else if(searchKey != null && "warehouseName".equals(searchKey)) {
		searchKey = "warehouseName";	
	}else if(searchKey != null && "showcasePlace".equals(searchKey)) {
		searchKey = "showcasePlace";	
	}
	// 검색키 검색어를 통해서 재고 조회
		
	List<Map<String, Object>> displayList = displayService.getDisplayBySearchKey(searchKey, searchValue, sessionMartCode, startDt, endDt);
	
	// 재고이동 model에 값을 저장
	model.addAttribute("title", "재고이동조회");
	model.addAttribute("displayList", displayList);
		
	return "stock_management/display/displayList";	
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
