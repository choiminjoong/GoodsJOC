package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.dto.ViewOrder;
import k5.goodsjoc.mapper.OrderMapper;

@Service
@Transactional
public class OrderService {
   private final OrderMapper orderMapper;
   
   public OrderService(OrderMapper orderMapper) {
      this.orderMapper = orderMapper;
   }
   
   //주문 전체조회
   public List<Order> getOrderList(){
      return orderMapper.getOrderList();
      
   }
   public List<ViewOrder> getViewOrder(){
	      return orderMapper.getViewOrder();	      
   }
   
   //주문 조건 검색
   public List<Order> getOrderListBySearchKey(String searchKey, String searchValue, String startDt, String endDt) {
	return orderMapper.getOrderListBySearchKey(searchKey, searchValue, startDt, endDt);
   }


   //매입내역 조회
	public List<Order> getOrderPurchaseList(String martCode) {
		return orderMapper.getOrderPurchaseList(martCode);
	}
	
	//주문등록화면
	public int orderInsert(Order order) {
		return orderMapper.orderInsert(order);
	}

	//거래명세서 매입정보만 가져오기
	public Order getPurchaseInfoByOrderCode(String orderCode) {
		return orderMapper.getPurchaseInfoByOrderCode(orderCode);
	}
	
	//매입 주문상세
	public List<OrderDetail> getPurchaseDetailList(String orderCode) {
		return orderMapper.getPurchaseDetailList(orderCode);
	}
	
	//주문서 상세 내역 테이블
	public List<OrderDetail> getsalesDetailList(String orderCode) {
		return orderMapper.getsalesDetailList(orderCode);
	}
	
	//상품검색모달
	public List<Map<String, Object>> getGoodsList(String sessionMartCode) {
		return orderMapper.getGoodsList(sessionMartCode);
	}
	
	//주문상세내역 거래처정보
	public List<Order> getOrderListByOrderCode(String orderCode) {
		return orderMapper.getOrderListByOrderCode(orderCode);
	}
		
	//매입 총 건수 및 가격
	public List<Map<String, Object>> purchaseDatePrice(String martCode) {
		return orderMapper.purchaseDatePrice(martCode);
	}

	//주문 총 가격
	public List<Map<String, Object>> totalOrderPrice(String martCode) {
		return orderMapper.totalOrderPrice(martCode);
	}
	
	public List<Order> searchPurchaseList(Map<String, Object> paramMap) {
		return orderMapper.searchPurchaseList(paramMap);
	}
	//주문등록
	public int orderInsertAction(Order order) {
		return orderMapper.orderInsertAction(order);
	}
	//주문등록 후 주문코드 넘기기
	public String searchOrderCode(Order order) {
		return orderMapper.searchOrderCode(order);
	}
	//주문상세등록
	public int orderInsertAction(OrderDetail orderDetail) {
		int result = 0;
		result += orderMapper.orderDetailInsertAction(orderDetail);
		
		return result;
	}
	
	//주문번호 중복검사
	public int orderCheckByorderNum(String order) {
		int result =0;
		result += orderMapper.orderCheckByorderNum(order);
		
		return result;
	}
	
	

}


   

   