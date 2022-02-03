package k5.goodsjoc.controller;

import java.util.HashMap;
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
	
    @PostMapping("/orderInsertAction")
    public String orderInsert(HttpServletRequest request, Order order, OrderDetail orderDetail) {
    	System.out.println("페이지: 주문 등록 ");
    	System.out.println("경로: product_management/order/orderInsertAction(POST방식 성공) ");   
		HttpSession session = request.getSession();
		
		String sessionMartCode = (String) session.getAttribute("SMARTCODE");
		String sessionId = (String) session.getAttribute("SID");

		order.setMartCode(sessionMartCode);
		order.setId(sessionId);
		order.setTotalOrderPrice(orderDetail.getTotalPrice());
		System.out.println("화면에서 받은 주문 정보 : "+  order);
		System.out.println("화면에서 받은 주문상세 정보 : "+  orderDetail);
		
		int result = orderService.orderInsertAction(order);
		if(result > 0) {
			String searchOrderCode = orderService.searchOrderCode(order);
			orderDetail.setOrderCode(searchOrderCode);
			
			int detailResult = orderService.orderInsertAction(orderDetail);
			if(detailResult > 0) {
				return "redirect:/product_management/order/orderList";
			}else{
				return "system_management/error/error500";
			}
		}else {
			return "system_management/error/error500";
		}
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
			,@RequestParam(value="searchState", required = false) String searchState
			,@RequestParam(value="startDt", required = false) String startDt
			,@RequestParam(value="endDt", required = false) String endDt
			,Model model){
		System.out.println(searchKey);
		System.out.println(searchValue);
		System.out.println(searchState);
					
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
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchState", searchState);	
	
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
		
		// 주문번호 사용여부확인 Ajax (정도혜)
		@PostMapping("/orderCheck")
		@ResponseBody
		public boolean orderCheck(@RequestParam(value="order", required=false) String order) {
			System.out.println("주문번호 사용여부 확인 버튼Ajax");
			System.out.println("등록폼에서 확인할 주문번호: " + order);
			
			boolean checkResult = false;
			int check = orderService.orderCheckByorderNum(order);
			if(check > 0) checkResult = true;
			
			return checkResult;
		}
		
		//주문 삭제처리
		@GetMapping("/orderDeleteAction")
		public String orderDeleteAction(@RequestParam(value="sendOrderCode", required= false) String orderCode) {
			orderService.orderDeleteAction(orderCode);
			System.out.println("주문 삭제처리 GET방식");
			
			return "redirect:/product_management/order/orderList";
		}
		
		//주문 승인
		@GetMapping("/orderChangePurchase")
		public String orderChangePurchase(@RequestParam(value="orderCode", required = false) String orderCode) {
			int orderChangeResult = orderService.orderChangePurchase(orderCode);
			
			if(orderChangeResult > 0) {
				List<OrderDetail> qtyList = orderService.getOrderQTYList(orderCode);
				if(qtyList != null) {
					int goodsUpdateResult = orderService.goodsUncheckedQTYUpdate(qtyList);
					
					if(goodsUpdateResult > 0) {
						System.out.println("상품수량정보 업데이트 완료");
						return "redirect:/product_management/order/orderList";
					}else {
						System.out.println("상품수량 업데이트 실패");
						return "system_management/error/error500";
					}
				}else {
					System.out.println("주문상세데이터 조회 실패");
					return "system_management/error/error500";
				}
			}else {
				System.out.println("주문승인 실패");
				return "system_management/error/error500";
			}
		}
		//주문 반려
		@GetMapping("/orderFail")
		public String orderFail(@RequestParam(value="orderCode", required = false) String orderCode) {
			orderService.orderFail(orderCode);
			
			return "redirect:/product_management/order/orderList";
		}
		//주문 취소
		@GetMapping("/orderCansel")
		public String orderCansel(@RequestParam(value="orderCode", required = false) String orderCode) {
			int detailCanselResult = orderService.deleteOrderDetail(orderCode);
			
			if(detailCanselResult > 0) {
				int orderCanselResult = orderService.deleteOrder(orderCode);
				if(orderCanselResult > 0) {
					return "redirect:/product_management/order/orderList";
				}else {
					System.out.println("주문취소 실패");
					return "system_management/error/error500";
				}
			}else {
				System.out.println("주문상세취소 실패");
				return "system_management/error/error500";
			}
		}
		
		
		
		
	}
