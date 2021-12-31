package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/stock_management/goodsReturn")
public class GoodsReturnController {

	@GetMapping("/returnInsert")
	public String returnInsert() {
		System.out.println("페이지: 반품 등록 ");
		System.out.println("경로: stock_management/goodsReturn/returnInsert(GET방식 성공) ");
		
		return "stock_management/goodsReturn/returnInsert";
	}

	@GetMapping("/returnList")
	public String returnList() {
		System.out.println("페이지: 반품 조회 ");
		System.out.println("경로: stock_management/goodsReturn/returnList(GET방식 성공) ");
		
		return "stock_management/goodsReturn/returnList";
	}

	@GetMapping("/returnUpdate")
	public String returnUpdate() {
		System.out.println("페이지: 반품 수정 ");
		System.out.println("경로: stock_management/goodsReturn/returnUpdate(GET방식 성공) ");
		
		return "stock_management/goodsReturn/returnUpdate";
	}
	
	
	
}
