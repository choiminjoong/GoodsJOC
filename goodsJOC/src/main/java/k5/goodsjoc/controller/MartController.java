package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/system_management/mart")
public class MartController {

	@GetMapping("/martInfo")
	public String martInfo(){
		System.out.println("페이지: 매장정보 ");
		System.out.println("경로: system_management/mart/martInfo(GET방식 성공) ");
		
		return "system_management/mart/martInfo";
	}
	@GetMapping("/martUpdate")
	public String martUpdate(){
		System.out.println("페이지: 매장정보 수정 ");
		System.out.println("경로: system_management/mart/martUpdate(GET방식 성공) ");
		
		return "system_management/mart/martUpdate";
	}
	@GetMapping("/sw_martInsert")
	public String martInsert(){
		System.out.println("페이지: 매장 등록 ");
		System.out.println("경로: system_management/mart/sw_martInsert(GET방식 성공) ");
		
		return "system_management/mart/sw_martInsert";
	}
	
}
