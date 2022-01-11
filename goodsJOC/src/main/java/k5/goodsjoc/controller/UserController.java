package k5.goodsjoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
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
		System.out.println("입력받은 ID: " + ID);
		System.out.println("입력받은 PW: " + PW);
		
		if(ID != null && !"".equals(ID) && PW != null && !"".equals(PW)){
			User userInfo = userService.getUserInfoByID(ID);
			System.out.println("userInfo: " + userInfo);
			Mart martInfo = martService.getMartInfoByMartCode(userInfo.getMartCode());
			System.out.println("martInfo: " + martInfo);
			
			if(userInfo != null && userInfo.getPW() != null && PW.equals(userInfo.getPW())) {
				session.setAttribute("SID", userInfo.getID());
				session.setAttribute("SNAME", userInfo.getName());
				session.setAttribute("SMARTCODE", martInfo.getMartCode());
				session.setAttribute("SMARTNAME", martInfo.getMartName());
				session.setAttribute("SLEVLEL", userInfo.getLevelNum());
				session.setAttribute("SPHONE", userInfo.getPhone());
				if(userInfo.getLevelNum().equals("1")) {
					session.setAttribute("SLEVELNAME", "SW개발사");
				}else if(userInfo.getLevelNum().equals("2")) {
					session.setAttribute("SLEVELNAME", "관리자");
				}else if(userInfo.getLevelNum().equals("3")) {
					session.setAttribute("SLEVELNAME", "매니저");
				}else if(userInfo.getLevelNum().equals("4")) {
					session.setAttribute("SLEVELNAME", "직원");
				}else if(userInfo.getLevelNum().equals("5")) {
					session.setAttribute("SLEVELNAME", "비권한자");
				}
				System.out.println("로그인 성공");
				return "redirect:/main";	
			}
			
		}
		System.out.println("로그인 실패");
		return "system_management/user/loginForm";
	}
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("페이지: 로그인 화면 ");
		System.out.println("경로: system_management/user/loginForm(GET방식 성공) ");
		
		return "system_management/user/loginForm";
	}
	
	@GetMapping("/userList")
	public String staffList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 사용자 목록 ");
		System.out.println("경로: system_management/user/userList(GET방식 성공) ");

		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<User> userList = userService.getUserList(sessionMartCode);
		model.addAttribute("userList", userList);
		System.out.println(userList);
		
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
	
	public String userInfo(HttpServletRequest request, Model model) {
		System.out.println("페이지: 직원상세");
		System.out.println("경로: system_management/user/userInfo(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("SID");
		User userInfo = userService.getUserInfoByID(sessionID);
		model.addAttribute("userInfo", userInfo);
		
		return "system_management/user/userInfo";
	}
	
	//사용자 검색
	@PostMapping("/userList")
	public String getSearchUserList(
			 @RequestParam(value="searchKey", required = false) String searchKey,
			@RequestParam(value="searchValue", required = false) String searchValue,
			Model model){
		System.out.println(searchKey);
		System.out.println(searchValue);
					
		if(searchKey != null && "name".equals(searchKey)) {
			searchKey = "name";
		}else if(searchKey != null && "phone".equals(searchKey)) {
			searchKey = "phone";
		}else if(searchKey != null && "email".equals(searchKey)) {
			searchKey = "email";		
		}else if(searchKey != null && "birthday".equals(searchKey)) {
			searchKey = "birthday";		
		}else  {
			searchKey = "levelNum";
		}
		// 검색키 검색어를 통해서 사용자목록 조회
			
		List<User> userList = userService.getUserListBySearchKey(searchKey, searchValue);
		
		// 조회된 회원목록 model에 값을 저장
		model.addAttribute("title", "사원목록조회");
		model.addAttribute("userList", userList);
			
		return "system_management/user/userList";
		}
	
	//사원정보 수정처리
	@PostMapping("/userUpdateAction") 
	 public String userUpdateAction(User user) {
		 System.out.println("페이지: 개인정보수정처리");
		 System.out.println("경로: system_management/user/userUpdateAction(POST방식 성공) ");
			
		 userService.updateUserInfo(user);
		 
		 return "redirect:/system_management/user/userInfo";
	 }
	
	
}
