package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mart")
public class MartController {

	@GetMapping("/martInfo")
	public String martInfo(){

		return "mart/martInfo";
	}
	
}
