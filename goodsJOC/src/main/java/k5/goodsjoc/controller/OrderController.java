package k5.goodsjoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k5.goodsjoc.dto.Business;
import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.ViewOrder;
import k5.goodsjoc.service.OrderService;

@Controller
@RequestMapping(value="/product_management/order")
public class OrderController {

	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@GetMapping("/orderInsert")
	public String orderInsert() {
		System.out.println("페이지: 주문 등록");
		System.out.println("경로: product_management/order/orderInsert(GET방식 성공) ");
		
		return "product_management/order/orderInsert";
	}

	@GetMapping("/orderList")
	public String orderList(Model model) {
		System.out.println("페이지: 주문 관리");
		System.out.println("경로: product_management/order/orderList(GET방식 성공) ");
		
		List<Order> orderList = orderService.getOrderList();
		model.addAttribute("orderList",orderList);		
		
		return "product_management/order/orderList";
	}
	
	@GetMapping("/orderDetail")
	public String orderDetail(Model model) {
		System.out.println("페이지: 주문 상세");
		System.out.println("경로: product_management/order/orderDetail(GET방식 성공) ");
		List<ViewOrder> viewOrder = orderService.getViewOrder();
		model.addAttribute("viewOrder",viewOrder);		
		
		
		return "product_management/order/orderDetail";
	}
	
		//주문 검색
		@PostMapping("/orderList")
		public String getSearchOrderList(
				@RequestParam(value="searchKey", required = false) String searchKey,
				@RequestParam(value="searchValue", required = false) String searchValue,
				@RequestParam(value="searchState", required=false) String searchState,
				Model model){
			System.out.println(searchKey);
			System.out.println(searchValue);
			System.out.println(searchState);
						
			if(searchKey != null && "orderNum".equals(searchKey)) {
				searchKey = "orderNum";
			}else if(searchKey != null && "businessName".equals(searchKey)) {
				searchKey = "businessName";	
			}else if(searchState != null && "state".equals(searchState)) {
				searchState = "state";	
			}else  {
				searchKey = "deliveryDate";
			}
			// 검색키 검색어를 통해서 사용자목록 조회
				
			List<Order> orderList = orderService.getOrderListBySearchKey(searchKey, searchValue);
			
			// 조회된 회원목록 model에 값을 저장
			model.addAttribute("title", "주문목록조회");
			model.addAttribute("orderList", orderList);
				
			return "product_management/order/orderList";
			}
		

	
}
