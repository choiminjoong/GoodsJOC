package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@GetMapping("/goodsCate")
	public String goodsCate() {

		return "goods/goodsCate";
	}
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		
		return "goods/goodsInsert";
	}
	@GetMapping("/goodsPrice")
	public String goodsPrice() {
		
		return "goods/goodsPrice";
	}
}
