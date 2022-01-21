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

   //매입내역 조회
	public List<Order> getOrderPurchaseList(String martCode) {
		return orderMapper.getOrderPurchaseList(martCode);
	}

	//거래명세서 매입정보만 가져오기
	public Order getPurchaseInfoByOrderCode(String orderCode) {
		return orderMapper.getPurchaseInfoByOrderCode(orderCode);
	}

	public List<OrderDetail> getPurchaseDetailList(String orderCode) {
		return orderMapper.getPurchaseDetailList(orderCode);
	}
	
	//매출등록
	public int orderInsert(Order order) {
		return orderMapper.orderInsert(order);
	}

	//매입 총 건수 및 가격
	public List<Map<String, Object>> purchaseDatePrice(String martCode) {
		return orderMapper.purchaseDatePrice(martCode);
	}

	public List<Order> searchPurchaseList(Map<String, Object> paramMap) {
		return orderMapper.searchPurchaseList(paramMap);
	}
}


   

   