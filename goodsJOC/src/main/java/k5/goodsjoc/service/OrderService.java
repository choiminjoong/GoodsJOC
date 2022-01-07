package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Order;
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
   
   
}