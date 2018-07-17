package com.gk.hgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.Order;
import com.gk.hgx.mapper.OrderMapper;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	public List<Order> myOrder(Integer uid){
		return orderMapper.findByUid(uid);
	}
	
	public Order get(Integer oid){
	  return orderMapper.get(oid); 	
	}

	public Order createOrder(Order order) {
        
		orderMapper.addOrder(order);
		orderMapper.addOrderItem(order.getOid(),order.getOrderItemList());
		return order;
		
	}
	
	public List<Order> findAll(){
		return orderMapper.findAll();
	}
	
	public List<Order> findByStatus(Integer status){
		return orderMapper.findByStatus(status);
	}

	public void updateOrderStatus(Integer oid,Integer status) {
       orderMapper.updateOrderStatus(oid,status);		
	}
	
	
}
