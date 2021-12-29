package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product_management/goods")
public class GoodsController {

	@GetMapping("/goodsCate")
	public String goodsCate() {

		return "product_management/goods/goodsCate";
	}
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		
		return "product_management/goods/goodsInsert";
	}
	@GetMapping("/goodsList")
	public String goodsList() {
		
		return "product_management/goods/goodsList";
	}
}
