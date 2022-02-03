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
	
	//주문삭제
	public int orderDeleteAction(String orderCode) {
		return orderMapper.orderDeleteAction(orderCode);
		
	}

	//1.주문승인
	public int orderChangePurchase(String orderCode) {
		int result = 0;
		result += orderMapper.orderChangePurchase(orderCode);
	
		return result;
	}
	//2.주문반려
	public void orderFail(String orderCode) {
		orderMapper.orderFail(orderCode);
		
	}
	//3.주문승인시 물품 수량 및 바코드
	public List<OrderDetail> getOrderQTYList(String orderCode) {
		return orderMapper.getOrderQTYList(orderCode);
	}
	//4.주문승인시 상품정보 업데이트
	public int goodsUncheckedQTYUpdate(List<OrderDetail> qtyList) {
		int result = 0;
		result += orderMapper.goodsUncheckedQTYUpdate(qtyList);

		return result;
	}
	//5.주문상세삭제
	public int deleteOrderDetail(String orderCode) {
		int result = 0;
		result += orderMapper.deleteOrderDetail(orderCode);

		return result;
	}
	//6.주문삭제
	public int deleteOrder(String orderCode) {
		int result = 0;
		result += orderMapper.deleteOrder(orderCode);
		
		return result;
	}

}


   

   