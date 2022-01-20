package k5.goodsjoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k5.goodsjoc.dto.Mart;
import k5.goodsjoc.service.MartService;

@Controller
@RequestMapping(value = "/system_management/mart")
public class MartController {
	private static final Logger log = LoggerFactory.getLogger(MartController.class);
	private final MartService martService;
	public MartController(MartService martService) {
		this.martService = martService;
	}	
	
	@PostMapping("/martSearchList")
	public String martSearchList(@RequestParam(value="startDate", required=false) String startDate,
								 @RequestParam(value="endDate", required=false) String endDate,
								 @RequestParam(value="serviceUse", required=false) String serviceUse,
								 @RequestParam(value="martName", required=false) String martName, Model model) {
		System.out.println("페이지: 매장 조건검색");
		Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("startDate", startDate);
			paramMap.put("endDate", endDate);
			paramMap.put("serviceUse", serviceUse);
			paramMap.put("martName", martName);
		List<Mart> martList = martService.getMartSearchList(paramMap);
		model.addAttribute("martList", martList);
		
		return "system_management/mart/sw_martList";
	}
	
	@GetMapping("/sw_martList")
	public String martList(Model model) {
		System.out.println("페이지: 매장리스트 ");
		List<Mart> martList = martService.getMartList();
		model.addAttribute("martList", martList);
		
		return "system_management/mart/sw_martList";
	}
	
	@PostMapping("/martInsertAction")
	public String martInsertAction(Mart mart) {
		System.out.println("매장 등록처리");
		int result = martService.martInsertAction(mart);
		
		return "/main";
	}
	
	@PostMapping("/martCodeCheck")
	@ResponseBody
	public boolean martCodeCheckAjax(@RequestParam(value="martCode", required=false) String martCode) {
		System.out.println("페이지: 매장코드유무 체크 Ajax ");
		System.out.println("경로: system_management/mart/martCodeCheck(POST방식 성공) ");
		boolean result = false;
		int num = martService.martCodeCheck(martCode);
		if(num > 0) {
			result = true;
		}
		
		return result;
	}

	@GetMapping("/martInfo")
	public String martInfo(HttpServletRequest request, Model model){
		System.out.println("페이지: 매장정보 ");
		System.out.println("경로: system_management/mart/martInfo(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		Mart martInfo = martService.getMartInfoByMartCode(sessionMartCode);
		model.addAttribute("martInfo", martInfo);
		System.out.println("model: " + martInfo);

		return "system_management/mart/martInfo";
	}
	@PostMapping("/martUpdate")
	public String martUpdate(Mart mart) {
		System.out.println("페이지: 매장정보 수정 ");
		System.out.println("경로: system_management/mart/martUpdate(POST방식 성공) ");
		log.info("수정화면에서 받은 martInfo: {}", mart);
		
		martService.updateMartInfo(mart);
		
		return "redirect:/system_management/mart/martInfo";
	}
	
	@GetMapping("/martUpdate")
	public String martUpdate(HttpServletRequest request, Model model){
		System.out.println("페이지: 매장정보 수정 ");
		System.out.println("경로: system_management/mart/martUpdate(GET방식 성공) ");

		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");		
		
		Mart martInfo = martService.getMartInfoByMartCode(sessionMartCode);
		model.addAttribute("martInfo", martInfo);
		System.out.println("model: " + martInfo);
		
		return "system_management/mart/martUpdate";
	}

	
	//나중에 개발사용 고객사업장 등록폼 사용할 예정
	@GetMapping("/sw_martInsert")
	public String martInsert(){
		System.out.println("페이지: 매장 등록 ");
		System.out.println("경로: system_management/mart/sw_martInsert(GET방식 성공) ");
		
		return "system_management/mart/sw_martInsert";
	}
	
}
