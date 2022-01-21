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
   
   public List<Order> getOrderList(){
      return orderMapper.getOrderList();
      
   }
   public List<ViewOrder> getViewOrder(){
	      return orderMapper.getViewOrder();
	      
   }
   
   // 주문 조건 검색
   public List<Order> getOrderListBySearchKey(String searchKey, String searchValue, String startDt, String endDt) {
	return orderMapper.getOrderListBySearchKey(searchKey, searchValue, startDt, endDt);
   }


	public List<Order> getOrderPurchaseList() {
		
		return orderMapper.getOrderPurchaseList();
	}

	//거래명세서 매입정보만 가져오기
	public Order getPurchaseInfoByOrderCode(String orderCode) {
		return orderMapper.getPurchaseInfoByOrderCode(orderCode);
	}
	
	//매입 주문상세
	public List<OrderDetail> getPurchaseDetailList(String orderCode) {
		return orderMapper.getPurchaseDetailList(orderCode);
	}
	
	//매출등록
	public int orderInsert(Order order) {
		return orderMapper.orderInsert(order);
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

}


   

   