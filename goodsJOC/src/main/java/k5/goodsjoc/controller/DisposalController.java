package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k5.goodsjoc.dto.Disposal;
import k5.goodsjoc.service.DisposalService;

@Controller
@RequestMapping(value="/stock_management/disposal")
public class DisposalController {
	private DisposalService disposalService;
	public DisposalController(DisposalService disposalService) {
		this.disposalService = disposalService;
	}

	@GetMapping("/disposalInsert")
	public String disposalInsert() {
		System.out.println("페이지: 폐기 등록 ");
		System.out.println("경로: stock_management/disposal/disposalInsert(GET방식 성공) ");
		
		return "stock_management/disposal/disposalInsert";
	}
	
	//폐기 검색(오대성)
		@PostMapping("/searchDisposalList")
		public String getDisposalBySearch(HttpServletRequest request,
				@RequestParam(value="searchKey", required = false) String searchKey,
				@RequestParam(value="searchValue", required = false) String searchValue,
				@RequestParam(value="startDt", required = false) String startDt,
				@RequestParam(value="endDt", required = false) String endDt,
				Model model){
			System.out.println(searchKey);
			System.out.println(searchValue);
			
			HttpSession session = request.getSession();
			String sessionMartCode = (String) session.getAttribute("SMARTCODE");
			
			if(searchKey != null && "goodsName".equals(searchKey)) {
				searchKey = "goodsName";
			}else if(searchKey != null && "name".equals(searchKey)) {
				searchKey = "name";	
			}else if(searchKey != null && "businessName".equals(searchKey)) {
				searchKey = "businessName";	
			}
				
			List<Disposal> disposalList = disposalService.getDisposalBySearch(searchKey, searchValue, sessionMartCode, startDt, endDt);
			
			// 조회된 폐기 목록 model에 값을 저장
			model.addAttribute("title", "폐기검색");
			model.addAttribute("disposalList", disposalList);
				
			return "stock_management/disposal/disposalList";
			}
	
	@GetMapping("/disposalList")
	public String disposalList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 폐기 정보조회 ");
		System.out.println("경로: stock_management/disposal/disposalList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Disposal> disposalList = disposalService.getDisposalList(sessionMartCode);
		model.addAttribute("disposalList", disposalList);
		
		return "stock_management/disposal/disposalList";
	}

	@GetMapping("/disposalUpdate")
	public String disposalUpdate() {
		System.out.println("페이지: 폐기 정보 수정");
		System.out.println("경로: stock_management/disposal/disposalUpdate(GET방식 성공) ");
		
		return "stock_management/disposal/disposalUpdate";
	}
	
	
}
