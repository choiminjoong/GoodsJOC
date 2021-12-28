package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		
		return "login/loginForm";
	}
	
	@GetMapping("/")
	public String main() {
	 
		return "main"; }

	
}
