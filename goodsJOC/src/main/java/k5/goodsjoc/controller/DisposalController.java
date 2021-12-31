package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/stock_management/disposal")
public class DisposalController {

	@GetMapping("/disposalInsert")
	public String disposalInsert() {
		System.out.println("페이지: 폐기 등록 ");
		System.out.println("경로: stock_management/disposal/disposalInsert(GET방식 성공) ");
		
		return "stock_management/disposal/disposalInsert";
	}

	@GetMapping("/disposalList")
	public String disposalList() {
		System.out.println("페이지: 폐기 정보조회 ");
		System.out.println("경로: stock_management/disposal/disposalList(GET방식 성공) ");
		
		return "stock_management/disposal/disposalList";
	}

	@GetMapping("/disposalUpdate")
	public String disposalUpdate() {
		System.out.println("페이지: 폐기 정보 수정");
		System.out.println("경로: stock_management/disposal/disposalUpdate(GET방식 성공) ");
		
		return "stock_management/disposal/disposalUpdate";
	}
	
	
}
