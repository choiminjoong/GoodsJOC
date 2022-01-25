package k5.goodsjoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/searchStaffModal")
	@ResponseBody
	public List<User> searchStaffModal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<User> result = userService.getSearchStaffList(sessionMartCode);
		
		return result;
	}
	
	@PostMapping("/sw_getUserInfo")
	@ResponseBody
	public User sw_getUserInfo(@RequestParam(value="id", required=false) String id) {
		User result = userService.getUserInfoByID(id);
		
		return result;
	}
	
	@PostMapping("/userInsertAction")
	public String userInsertAction(User user) {
		System.out.println("페이지: 회원가입처리 ");
		System.out.println("경로: system_management/user/userInsertAction(POST방식) ");		
		System.out.println("입력받은 정보: " + user);
		int result = userService.userInsertAction(user);
		
		return "system_management/user/loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃 완료");
		
		return "redirect:/system_management/user/loginForm";
	}
	
	@PostMapping("/loginCheck")
	@ResponseBody
	public int loginCheck(@RequestParam(value="loginId", required=false) String id,
						  @RequestParam(value="loginPw", required=false) String pw) {
		System.out.println("입력받은 ID: " + id);
		System.out.println("입력받은 PW: " + pw);
		int result = 0;

		if(id != null && !"".equals(id)) {
			User userInfo = userService.getUserInfoByID(id);
			
			if(userInfo != null && !"".equals(userInfo)) {
				if(pw != null && !"".equals(pw)) {
					if(pw.equals(userInfo.getPw())){
						//비번이 같은경우(로그인 성공)
						result = 4;
					}else {
						//비번이 틀린경우
						result = 3;
					}
				}else {
					//비번을 안 쓴경우
					result = 2;
				}
			}else{
				//아이디로 찾은 유저정보가 없는 경우
				result = 1;
			}
		}else {
			//아이디를 안쓴경우
			result = 0;
		}
		
		return result;
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam(value="id", required=false) String id,
						@RequestParam(value="pw", required=false) String pw, HttpSession session) {
		System.out.println("페이지: 로그인처리 ");
		System.out.println("경로: system_management/user/loginForm(POST방식) ");		
		System.out.println("입력받은 ID: " + id);
		System.out.println("입력받은 PW: " + pw);
		
		if(id != null && !"".equals(id) && pw != null && !"".equals(pw)){
			User userInfo = userService.getUserInfoByID(id);
			System.out.println("userInfo: " + userInfo);
			Mart martInfo = martService.getMartInfoByMartCode(userInfo.getMartCode());
			System.out.println("martInfo: " + martInfo);
			
			if(userInfo != null && userInfo.getPw() != null && pw.equals(userInfo.getPw())) {
				session.setAttribute("SID", userInfo.getId());
				session.setAttribute("SNAME", userInfo.getName());
				session.setAttribute("SMARTCODE", martInfo.getMartCode());
				session.setAttribute("SMARTNAME", martInfo.getMartName());
				session.setAttribute("SMARTINFO", martInfo);
				session.setAttribute("SLEVEL", userInfo.getLevelNum());
				session.setAttribute("SPHONE", userInfo.getPhone());
				if(userInfo.getLevelNum().equals("1")) {
					session.setAttribute("SLEVELNAME", "SW관리자");
				}else if(userInfo.getLevelNum().equals("2")) {
					session.setAttribute("SLEVELNAME", "관리자");
				}else if(userInfo.getLevelNum().equals("3")) {
					session.setAttribute("SLEVELNAME", "매니저");
				}else if(userInfo.getLevelNum().equals("4")) {
					session.setAttribute("SLEVELNAME", "직원");
				}else if(userInfo.getLevelNum().equals("5")) {
					session.setAttribute("SLEVELNAME", "비권한자");
				}
				//세션 시간 24시간
				session.setMaxInactiveInterval(60*60*24);
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
	// 사원관리 조회화면
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
   
   //직원관리 > 직원검색(정도혜)
   @PostMapping("/userList")
   public String getSearchUserList(HttpServletRequest request,
          @RequestParam(value="searchKey", required = false) String searchKey,
         @RequestParam(value="searchValue", required = false) String searchValue,
         Model model){
      System.out.println(searchKey);
      System.out.println(searchValue);
      
      HttpSession session = request.getSession();
      String sessionMartCode = (String) session.getAttribute("SMARTCODE");  
      
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

      List<User> userList = userService.getUserListBySearchKey(searchKey, searchValue, sessionMartCode);

      
      // 조회된 회원목록 model에 값을 저장
      model.addAttribute("title", "사원목록조회");
      model.addAttribute("userList", userList);
         
      return "system_management/user/userList";
      }
   
   	//직원관리 > 직원정보 수정처리(정도혜)
   	   @PostMapping("/userUpdateAction") 
   	   public String userUpdateAction(User user) {
	   System.out.println("페이지: 개인정보수정처리");
	   System.out.println("경로: system_management/user/userUpdateAction(POST방식 성공) ");
         
       userService.updateUserInfo(user);
       
       return "redirect:/system_management/user/userInfo";
    }
    
     //직원관리 > 직원권한 수정화면 (정도혜)     
     @GetMapping("/userUpdate") 
     public String userUpdate(@RequestParam(value="id", required = false) String id, Model model) {
     System.out.println("페이지: 사원권한수정 ");
     System.out.println("경로: system_management/user/userUpdate(GET방식 성공) "); 
     System.out.println("리트스에서 받은 아이디: " + id);
     
     User userUpdate = userService.getUserInfoByID(id);
     model.addAttribute("userUpdate", userUpdate);
     System.out.println("모델에 담긴 비즈니스정보: " + model);
     
     return "system_management/user/userUpdate";
     }
     
     //직원관리 > 직원권한 수정 작업 (정도혜)
     @PostMapping("/userLevelUpdate") 
     public String userLevelUpdate(User user) 
     { System.out.println("페이지: 사원권한 수정 ");
     System.out.println("경로: system_management/user/userLevelUpdate(POST방식 성공) "); 
     log.info("수정화면에서 받은 userUpdate : {}", user);
     
     userService.updateUserLevel(user);
     
     return "redirect:/system_management/user/userList";
     }   
     
   // 사용자 아이디 중복확인 (정도혜)
 	@PostMapping("/userIdCheck")
 	@ResponseBody
 	public boolean useridCheck(@RequestParam(value="userId", required=false) String userId) {
 		System.out.println("아이디 사용여부 확인 버튼Ajax");
 		System.out.println("등록폼에서 확인할 아이디: " + userId);
 		
 		boolean checkResult = false;
 		int check = userService.getUserByUserId(userId);
 		if(check > 0) checkResult = true;
 		
 		return checkResult;
 	} 
 	
 	@PostMapping("/totalUserSearchList")
 	public String totalUserSearchList(@RequestParam(value="deleteStatus", required=false) String deleteStatus,
 									  @RequestParam(value="startDate", required=false) String startDate,
 									  @RequestParam(value="endDate", required=false) String endDate,
 									  @RequestParam(value="levelNum", required=false) String levelNum,
 									  @RequestParam(value="martName", required=false) String martName,
 									  @RequestParam(value="name", required=false) String name, Model model) {
 		Map<String, Object> paramMap = new HashMap<String, Object>();
	 		paramMap.put("deleteStatus", deleteStatus);
			paramMap.put("startDate", startDate);
			paramMap.put("endDate", endDate);
			paramMap.put("levelNum", levelNum);
			paramMap.put("martName", martName);
			paramMap.put("name", name);
 		List<User> totalUserList = userService.getTotalUserSearchList(paramMap);
 		model.addAttribute("totalUserList", totalUserList);
 		
 		return "system_management/user/sw_userList";
 	}
 	
 	@GetMapping("/sw_userList")
 	public String totalUserList(Model model) {
 		List<User> totalUserList = userService.getTotalUserList();
 		model.addAttribute("totalUserList", totalUserList);
 		
 		return "system_management/user/sw_userList";
 	}
 	
 	@GetMapping("/userActive")
 	public String userActive(String id) {
 		userService.userActive(id);
 		
 		return "redirect:/system_management/user/sw_userList";
 	}
 	@GetMapping("/userNoActive")
 	public String userNoACtive(String id) {
 		userService.userNoActive(id);
 		
 		return "redirect:/system_management/user/sw_userList";
 	}
}




