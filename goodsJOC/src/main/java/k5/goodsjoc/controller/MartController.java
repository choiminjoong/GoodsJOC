package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/system_management/mart")
public class MartController {

	@GetMapping("/martInfo")
	public String martInfo(){

		return "system_management/mart/martInfo";
	}
	
}
