package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k5.goodsjoc.dto.Business;
import k5.goodsjoc.service.BusinessService;

@Controller
@RequestMapping(value = "/basic_management/business")
public class BusinessController {	
	
	private static final Logger log = LoggerFactory.getLogger(BusinessController.class);

	private final BusinessService businessService;
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	// 거래처 리스트 조회
	@GetMapping("/businessList")
	public String businessList(Model model, HttpServletRequest request) {
		System.out.println("페이지: 거래처 관리 ");
		System.out.println("경로: basic_management/business/businessList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Business> businessList = businessService.getBusinessList(sessionMartCode);
		model.addAttribute("businessList", businessList);

		return "basic_management/business/businessList";
	}
	
	// 거래처 검색
	@PostMapping("/businessList")
	public String getSearchBusinessList(
			 @RequestParam(value="searchKey", required = false) String searchKey
			,@RequestParam(value="searchValue", required = false) String searchValue
			,Model model) {
		System.out.println(searchKey);
		System.out.println(searchValue);
		log.info("searchKey 조회결과------------------------->>>>>>>>>>>>>>>{}", searchKey);
		log.info("searchValue 조회결과------------------------->>>>>>>>>>>>>>>{}", searchValue);
		
		if(searchKey != null && "businessName".equals(searchKey)) {
			searchKey = "businessName";
		}else if(searchKey != null && "businessType".equals(searchKey)) {
			searchKey = "businessType";
		}else if(searchKey != null && "partnerName".equals(searchKey)) {
			searchKey = "partnerName";		
		}else  {
			searchKey = "sectors";
		}
		// 검색키 검색어를 통해서 회원목록 조회
		
		List<Business> businessList = businessService.getBusinessListBySearchKey(searchKey, searchValue);
		
		// 조회된 회원목록 model에 값을 저장
		model.addAttribute("title", "거래처목록조회");
		model.addAttribute("businessList", businessList);
		log.info("조회결과------------------------->>>>>>>>>>>>>>>",businessList);
		
		return "basic_management/business/businessList";
	}

	
	// 거래처 등록
	@GetMapping("/businessInsert")
	public String businessInsert() {
		System.out.println("페이지: 거래처 등록 ");
		System.out.println("경로: basic_management/business/businessInsert(GET방식 성공) ");		
		
		return "basic_management/business/businessInsert";
	}
		
	// 거래처 수정화면
	@GetMapping("/businessUpdate")
	public String businessUpdate(@RequestParam(value="businessCode", required = false) String businessCode, Model model) {		
		System.out.println("페이지: 거래처 수정 ");
		System.out.println("경로: basic_management/business/businessUpdate(GET방식 성공) ");		
		System.out.println("리트스에서 받은 거래처 코드: "  + businessCode);
				
		Business businesslnfo = businessService.getBusinessInfoByCode(businessCode);
		model.addAttribute("businesslnfo", businesslnfo);
		System.out.println("모델에 담긴 비즈니스정보: " + model);		
		
		return "basic_management/business/businessUpdate";
		}	

	// 거래처 수정 작업
	@PostMapping("/businessUpdate")
	public String businessUpdate(Business business) {		
		System.out.println("페이지: 거래처 수정 ");
		System.out.println("경로: basic_management/business/businessUpdate(POST방식 성공) ");		
		log.info("수정화면에서 받은 businessinfo : {}", business);
		
		businessService.updateBusinessInfo(business);
		
		return "redirect:/basic_management/business/businessList";
	}	
	
	
	//거래처 등록
	@PostMapping("/businessInsert")
	public String businessInsert(Business business) {
		System.out.println("페이지: 거래처 등록 ");
		System.out.println("경로: basic_management/business/businessInsert(POST방식 성공) ");	
		System.out.println("화면에서 받은 거래처 정보 : "+  business);
		
		businessService.businessInsert(business);
		
		return "redirect:/basic_management/business/businessList";
	}
	
}

