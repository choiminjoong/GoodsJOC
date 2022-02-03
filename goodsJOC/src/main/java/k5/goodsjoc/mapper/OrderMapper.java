package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.OrderDetail;
import k5.goodsjoc.dto.ViewOrder;

@Mapper
public interface OrderMapper {
		
	//주문등록화면
	public int orderInsert(Order order);
	
	//주문 전체 조회
	public List<Order> getOrderList();

	//주문내역 상세 조회
	public List<ViewOrder> getViewOrder();
	
	//주문 단일정보 검색
	public List<Order> getOrderListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);
	
	//매입(주문상태=승인) 리스트 가져오기
	public List<Order> getOrderPurchaseList(String martCode);

	//매입(주문상태=승인)
	public Order getPurchaseInfoByOrderCode(String orderCode);
	
	//매입 총 건수및 가격
	public List<Map<String, Object>> purchaseDatePrice(String martCode);

	//매입 조건검색
	public List<Order> searchPurchaseList(Map<String, Object> paramMap);

	//주문상세
	public List<OrderDetail> getPurchaseDetailList(String orderCode);

	//주문서 상세내역 테이블
	public List<OrderDetail> getsalesDetailList(String orderCode);

	//상품검색모달
	public List<Map<String, Object>> getGoodsList(String sessionMartCode);

	//주문거래처정보
	public List<Order> getOrderListByOrderCode(String orderCode);
	
	//주문총가격
	public List<Map<String, Object>> totalOrderPrice(String martCode);
	
	//주문등록
	public int orderInsertAction(Order order);
	
	//주문등록후 orderCode 넘겨주기
	public String searchOrderCode(Order order);
	
	//주문상세등록
	public int orderDetailInsertAction(OrderDetail orderDetail);

	//주문번호 중복검사
	public int orderCheckByorderNum(String order);
	
	//주문삭제
	public int orderDeleteAction(String orderCode);


}
