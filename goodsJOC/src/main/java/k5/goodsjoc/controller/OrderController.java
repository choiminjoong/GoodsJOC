package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/product_management/order")
public class OrderController {

	@GetMapping("/orderInsert")
	public String orderInsert() {
		System.out.println("페이지: 주문 등록");
		System.out.println("경로: product_management/order/orderInsert(GET방식 성공) ");
		
		return "product_management/order/orderInsert";
	}

	@GetMapping("/orderList")
	public String orderList() {
		System.out.println("페이지: 주문 관리");
		System.out.println("경로: product_management/order/orderList(GET방식 성공) ");
		
		return "product_management/order/orderList";
	}

	@GetMapping("/orderDetail")
	public String orderDetail() {
		System.out.println("페이지: 주문 상세");
		System.out.println("경로: product_management/order/orderDetail(GET방식 성공) ");
		
		return "product_management/order/orderDetail";
	}
	
}
