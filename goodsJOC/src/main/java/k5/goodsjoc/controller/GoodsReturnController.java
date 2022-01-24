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

import k5.goodsjoc.dto.GoodsReturn;
import k5.goodsjoc.service.GoodsReturnService;

@Controller
@RequestMapping(value="/stock_management/goodsReturn")
public class GoodsReturnController {
	private GoodsReturnService goodsReturnService;
	public GoodsReturnController(GoodsReturnService goodsReturnService) {
		this.goodsReturnService = goodsReturnService;
	}

	@GetMapping("/returnInsert")
	public String returnInsert() {
		System.out.println("페이지: 반품 등록 ");
		System.out.println("경로: stock_management/goodsReturn/returnInsert(GET방식 성공) ");
		
		return "stock_management/goodsReturn/returnInsert";
	}
	
	//반품 검색
	@PostMapping("/searchReturnList")
	public String searchReturnList(HttpServletRequest request,
									@RequestParam(value="searchKey", required = false) String searchKey,
									@RequestParam(value="searchValue", required = false) String searchValue,
									@RequestParam(value="startDt", required = false) String startDt,
									@RequestParam(value="endDt", required = false) String endDt,
									Model model) {
		
		System.out.println(searchKey);
		System.out.println(searchValue);
		System.out.println(startDt);
		System.out.println(endDt);
		
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
		
		List<GoodsReturn> goodsReturnList = goodsReturnService.getSearchGoodsReturnList(sessionMartCode, searchKey, searchValue, startDt, endDt);
		
		model.addAttribute("title", "반품 검색");
		model.addAttribute("goodsReturnList", goodsReturnList);
		
		return "stock_management/goodsReturn/returnList";
	}

	@GetMapping("/returnList")
	public String returnList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 반품 조회 ");
		System.out.println("경로: stock_management/goodsReturn/returnList(GET방식 성공) ");
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<GoodsReturn> goodsReturnList = goodsReturnService.getGoodsReturnList(sessionMartCode);
		model.addAttribute("goodsReturnList", goodsReturnList);
		
		return "stock_management/goodsReturn/returnList";
	}

	@GetMapping("/returnUpdate")
	public String returnUpdate() {
		System.out.println("페이지: 반품 수정 ");
		System.out.println("경로: stock_management/goodsReturn/returnUpdate(GET방식 성공) ");
		
		return "stock_management/goodsReturn/returnUpdate";
	}	
	
	
	
}
