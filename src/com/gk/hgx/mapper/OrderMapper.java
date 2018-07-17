package com.gk.hgx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gk.hgx.bean.Order;
import com.gk.hgx.bean.OrderItem;

public interface OrderMapper {

	public List<Order> findByUid(Integer uid);
	
	
	public List<OrderItem> findByOid(Integer oid);
	
	public Order get(Integer oid);


	public void addOrder(Order order);


	public void addOrderItem(@Param("oid") Integer oid,@Param("orderItemList")  List<OrderItem> orderItemList);
	
	public List<Order> findAll();//查询所有订单包括订单项
	
	public List<Order> findByStatus(Integer status);//根据status查询所有订单包括订单项


	public void updateOrderStatus(@Param("oid") Integer oid,@Param("status") Integer status);//根据oid修改订单的状态
	
	
}
