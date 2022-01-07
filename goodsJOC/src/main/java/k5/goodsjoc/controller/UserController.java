package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "/system_management/user")
public class UserController {

	@GetMapping("/userList")
	public String staffList() {
		System.out.println("페이지: 사용자 목록 ");
		System.out.println("경로: system_management/user/userList(GET방식 성공) ");
		
		return "system_management/user/userList";
	}

	@GetMapping("/userInsert")
	public String userInsert() {
		System.out.println("페이지: 회원가입 ");
		System.out.println("경로: system_management/user/userInsert(GET방식 성공) ");
		
		return "system_management/user/userInsert";
	}

	@GetMapping("/userUpdate")
	public String userUpdate() {
		System.out.println("페이지: 개인정보수정 ");
		System.out.println("경로: system_management/user/userUpdate(GET방식 성공) ");
		
		return "system_management/user/userUpdate";
	}

	@GetMapping("/userInfo")
	public String userInfo() {
		System.out.println("페이지: 직원상세");
		System.out.println("경로: system_management/user/userInfo(GET방식 성공) ");
		
		return "system_management/user/userInfo";
	}
	
}
