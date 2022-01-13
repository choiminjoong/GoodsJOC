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

import k5.goodsjoc.dto.Warehousing;
import k5.goodsjoc.service.WarehousingService;

@Controller
@RequestMapping(value="/stock_management/warehousing")
public class WarehousingController {

	private WarehousingService warehousingService;
	public WarehousingController(WarehousingService warehousingService) {
		this.warehousingService = warehousingService;
	}
	
	@GetMapping("/warehousingInsert")
	public String warehousingInsert() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingInsert(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingInsert";
	}
	
	//입고 검색(오대성)
	@PostMapping("/warehousingList")
	public String getSearchOrderList(HttpServletRequest request,
			@RequestParam(value="searchKey", required = false) String searchKey,
			@RequestParam(value="searchValue", required = false) String searchValue,
			Model model){
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
		}else if(searchKey != null && "shelfName".equals(searchKey)) {
			searchKey = "shelfName";	
		}
		// 검색키 검색어를 통해서 입고목록 조회
			
		List<Warehousing> warehousingList = warehousingService.getWarehousingBySearchKey(searchKey, searchValue, sessionMartCode);
		
		// 조회된 입고 목록 model에 값을 저장
		model.addAttribute("title", "입고조회");
		model.addAttribute("warehousingList", warehousingList);
			
		return "stock_management/warehousing/warehousingList";	
		}
	
	@GetMapping("/warehousingList")
	public String warehousingList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 입고 조회");
		System.out.println("경로: stock_management/warehousing/warehousingList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Warehousing> warehousingList = warehousingService.getWarehousingList(sessionMartCode);
		model.addAttribute("warehousingList",warehousingList);		
		
		return "stock_management/warehousing/warehousingList";
	}
	
	@GetMapping("/warehousingUpdate")
	public String warehousingUpdate() {
		System.out.println("페이지: 입고 등록 ");
		System.out.println("경로: stock_management/warehousing/warehousingUpdate(GET방식 성공) ");
		
		return "stock_management/warehousing/warehousingUpdate";
	}
}
