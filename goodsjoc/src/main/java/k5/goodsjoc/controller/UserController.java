package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "/system_management/user")
public class UserController {

	@GetMapping("/userList")
	public String staffList() {
		
		return "system_management/user/userList";
	}
	
}
