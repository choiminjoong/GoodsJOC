package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.dto.ViewOrder;

@Mapper
public interface OrderMapper {
	
	//주문 전체 조회
	public List<Order> getOrderList();

	//주문내역 상세 조회
	public List<ViewOrder> getViewOrder();
	
	//주문 단일정보 검색
	public List<Order> getOrderListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);
	//매입(주문상태=승인) 리스트 가져오기
	public List<Order> getOrderPurchaseList();
	//매입(주문상태=승인)
	public Order getPurchaseInfoByOrderCode(String orderCode);
	
	//주문등록
	public int orderInsert(Order order);

	//주문상세
	public List<OrderDetail> getPurchaseDetailList(String orderCode);

	//주문서 상세내역
	public List<OrderDetail> getsalesDetailList(String orderCode);
	
}
