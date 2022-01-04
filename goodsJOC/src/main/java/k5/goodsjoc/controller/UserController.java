package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k5.goodsjoc.service.MartService;
import k5.goodsjoc.service.UserService;
import k5.goodsjoc.dto.Mart;
import k5.goodsjoc.dto.User;

@Controller
@RequestMapping(value= "/system_management/user")
public class UserController {

	private MartService martService;
	private UserService userService;
	public UserController(UserService userService, MartService martService) {
		this.userService = userService;
		this.martService = martService;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃 완료");
		
		return "redirect:/system_management/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="ID", required=false) String ID,
						@RequestParam(value="PW", required=false) String PW, HttpSession session) {
		
		System.out.println("페이지: 로그인처리 ");
		System.out.println("경로: system_management/user/loginForm(POST방식) ");		
		
		if(ID != null && !"".equals(ID) && PW != null && !"".equals(PW)){
			User userInfo = userService.getUserInfoByID(ID);
			Mart martInfo = martService.getMartInfoByMartCode(userInfo.getMartCode());
			
			if(userInfo != null && userInfo.getPW() != null && PW.equals(userInfo.getPW())) {
				session.setAttribute("SID", ID);
				session.setAttribute("SNAME", userInfo.getName());
				session.setAttribute("SMART", martInfo.getMartName());
				if(userInfo.getLevelNum().equals("1")) {
					session.setAttribute("SLEVEL", "SW개발사");
				}else if(userInfo.getLevelNum().equals("2")) {
					session.setAttribute("SLEVEL", "관리자");
				}else if(userInfo.getLevelNum().equals("3")) {
					session.setAttribute("SLEVEL", "매니저");
				}else if(userInfo.getLevelNum().equals("4")) {
					session.setAttribute("SLEVEL", "직원");
				}else if(userInfo.getLevelNum().equals("5")) {
					session.setAttribute("SLEVEL", "비권한자");
				}
				System.out.println("session: " + session);
				
				return "redirect:/main";	
			}
		}
		
		return "system_management/user/loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("페이지: 로그인 화면 ");
		System.out.println("경로: system_management/user/loginForm(GET방식 성공) ");
		
		return "system_management/user/loginForm";
	}
	
	@GetMapping("/userList")
	public String staffList(Model model) {
		System.out.println("페이지: 사용자 목록 ");
		System.out.println("경로: system_management/user/userList(GET방식 성공) ");

		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		
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
