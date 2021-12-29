package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/product_management/order")
public class OrderController {

	@GetMapping("/orderInsert")
	public String orderInsert() {

		return "product_management/order/orderInsert";
	}
	
	
	
	
}
