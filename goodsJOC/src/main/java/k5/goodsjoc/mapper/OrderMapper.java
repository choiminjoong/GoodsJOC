package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Order;
import k5.goodsjoc.dto.ViewOrder;

@Mapper
public interface OrderMapper {
	
	//주문 전체 조회
	public List<Order> getOrderList();

	//주문내역 상세 조회
	public List<ViewOrder> getViewOrder();

	
}
