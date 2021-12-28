package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "/staff")
public class StaffController {

	@GetMapping("/staffList")
	public String staffList() {
		
		return "staff/staffList";
	}
	
	@GetMapping("/staffInsert")
	public String staffInsert() {
		
		return "staff/staffInsert";
	}
}
