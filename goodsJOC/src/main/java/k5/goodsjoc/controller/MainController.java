package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login() {
	 
		return "main"; 
	}
	@GetMapping("/main")
	public String main() {
		
		return "main"; 
	}

	
}