package k5.goodsjoc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.service.OrderService;

@Controller
@RequestMapping(value="/product_management/order")
public class OrderController {
	private OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//주문관리 > 주문등록화면 (정도혜)
	@GetMapping("/orderInsert")
	public String orderInsert() {
		System.out.println("페이지: 주문 등록");
		System.out.println("경로: product_management/order/orderInsert(GET방식 성공) ");
		
		return "product_management/order/orderInsert";
	}
	
    @PostMapping("/orderInsert")
    public String orderInsert(Order order) {
       System.out.println("페이지: 주문 등록 ");
       System.out.println("경로: product_management/order/orderInsert(POST방식 성공) ");   
       System.out.println("화면에서 받은 주문 정보 : "+  order);
       
       orderService.orderInsert(order);
       
       return "redirect:/product_management/order/orderList";
    }
    
	//주문관리 > 주문목록 (정도혜)
	@GetMapping("/orderList")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("페이지: 주문 관리");
		System.out.println("경로: product_management/order/orderList(GET방식 성공) ");
		
		HttpSession session = request.getSession();
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		
		List<Order> orderList = orderService.getOrderList();
		model.addAttribute("orderList",orderList);

		List<Map<String, Object>> totalOrderPrice = orderService.totalOrderPrice(sessionMartCode);
		model.addAttribute("totalOrderPrice", totalOrderPrice);	
		System.out.println(totalOrderPrice);
		
		return "product_management/order/orderList";
	}
	
	//주문관리 > 주문상세 (정도혜)	
	@GetMapping("/orderDetail")
	   public String returnList(@RequestParam(value="orderCode", required = false)String orderCode, Model model) {
	      System.out.println("페이지: 주문상세 조회 ");
	      System.out.println("경로:  product_management/order/orderDetail(GET방식 성공) ");	     
	      System.out.println("orderCode:" + orderCode);	     
	      
	      List<OrderDetail> orderDetailList = orderService.getsalesDetailList(orderCode);
	      model.addAttribute("orderDetailList", orderDetailList);      
	      
		  List<Order> orderList = orderService.getOrderListByOrderCode(orderCode);
		  model.addAttribute("orderList", orderList);
		 
	      
	      return "product_management/order/orderDetail";
	   }
	
	
	//주문관리 > 주문 검색 (정도혜)
	@PostMapping("/orderList")
	public String getSearchOrderList(
			@RequestParam(value="searchKey", required = false) String searchKey
			,@RequestParam(value="searchValue", required = false) String searchValue
			,@RequestParam(value="startDt", required = false) String startDt
			,@RequestParam(value="endDt", required = false) String endDt
			,Model model){
		System.out.println(searchKey);
		System.out.println(searchValue);
					
		if(searchKey != null && "orderNum".equals(searchKey)) {
			searchKey = "orderNum";
		}else if(searchKey != null && "businessName".equals(searchKey)) {
			searchKey = "businessName";	
		}else if(searchKey != null && "state".equals(searchKey)) {
			searchKey = "state";	
		}else  {
			searchKey = "deliveryDate";
		}

		// 검색키 검색어를 통해서 사용자목록 조회	
		List<Order> orderList = orderService.getOrderListBySearchKey(searchKey, searchValue, startDt, endDt);
		
		// 조회된 회원목록 model에 값을 저장
		model.addAttribute("title", "주문목록조회");
		model.addAttribute("orderList", orderList);
			
		return "product_management/order/orderList";
		}
	
		//상품선택 모달 Ajax (정도혜)
		@PostMapping("/searchGoodsModal")
		@ResponseBody
		public List<Map<String, Object>> searchGoodsModal(HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			String sessionMartCode = (String) session.getAttribute("SMARTCODE");
			
			List<Map<String, Object>> goodsModal = orderService.getGoodsList(sessionMartCode);
			
			return goodsModal;
		}	
	
	}
