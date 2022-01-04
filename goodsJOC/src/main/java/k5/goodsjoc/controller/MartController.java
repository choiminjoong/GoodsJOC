package k5.goodsjoc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k5.goodsjoc.dto.Mart;
import k5.goodsjoc.service.MartService;

@Controller
@RequestMapping(value = "/system_management/mart")
public class MartController {

	private static final Logger log = LoggerFactory.getLogger(MartController.class);

	private MartService martService;
	
	public MartController(MartService martService) {
		this.martService = martService;
	}	
	
	//조회
	@GetMapping("/martInfo")
	public String martInfo(Model model){
		System.out.println("페이지: 매장정보 ");
		System.out.println("경로: system_management/mart/martInfo(GET방식 성공) ");
	
		Mart martInfo = martService.getMartInfoByMartCode("JBJJ001");
		model.addAttribute("martInfo", martInfo);
		System.out.println("model: " + martInfo);

		return "system_management/mart/martInfo";
	}
	@GetMapping("/martUpdate")
	public String martUpdate(Model model){
		System.out.println("페이지: 매장정보 수정 ");
		System.out.println("경로: system_management/mart/martUpdate(GET방식 성공) ");
		
		Mart martInfo = martService.getMartInfoByMartCode("JBJJ001");
		model.addAttribute("martInfo", martInfo);
		System.out.println("model: " + martInfo);
		
		return "system_management/mart/martUpdate";
	}
	@GetMapping("/sw_martInsert")
	public String martInsert(){
		System.out.println("페이지: 매장 등록 ");
		System.out.println("경로: system_management/mart/sw_martInsert(GET방식 성공) ");
		
		return "system_management/mart/sw_martInsert";
	}
	
}
