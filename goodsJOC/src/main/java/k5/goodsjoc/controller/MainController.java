package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
	 
		return "system_management/user/loginForm"; 
	}
	
	@GetMapping("/")
	public String main() {
		
		return "mainPage"; 
	}
	
	@GetMapping("/main")
	public String mainForm() {
		
		return "main"; 
	}
	@GetMapping("/error500")
	public String error500() {
		
		return "system_management/error/error500"; 
	}

	@GetMapping("/mainPage")
	public String mainPage() {
		return "mainPage";
	}
	
}
