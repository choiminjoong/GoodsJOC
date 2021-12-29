package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/trade_management/order")
public class TradeController {

	@GetMapping("/orderInsert")
	public String orderInsert() {

		return "product_management/order/orderInsert";
	}
	
	
	
	
}
