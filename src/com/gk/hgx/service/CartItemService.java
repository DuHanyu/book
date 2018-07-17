package com.gk.hgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.CartItem;
import com.gk.hgx.mapper.CartItemMapper;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemMapper cartItemMapper;

	public List<CartItem> myCart(Integer uid)
	{
		return cartItemMapper.myCart(uid);
	}

	public void add(CartItem cartItem) {
		 
		CartItem cartItem2=cartItemMapper.queryByUidAndBid(cartItem);
		if(cartItem2==null) {
			cartItemMapper.add(cartItem);
		}else {
			cartItem.setCartItemId(cartItem2.getCartItemId());
			cartItem.setQuantity(cartItem2.getQuantity()+cartItem.getQuantity());
			cartItemMapper.updateByCartItemId(cartItem);
		}
		
	}
	
	public void batchDelete(List<Integer> lists) {
		cartItemMapper.batchDelete(lists);
	}
	
	public List<CartItem> findByCartItemIds(List<Integer> cartItemIds){
		return cartItemMapper.findByCartItemIds(cartItemIds);
	}

	/*public CartItem updateQuantity(CartItem cartItem) {
	     cartItemMapper.updateByCartItemId(cartItem);
	     return cartItemMapper.findByCartItemId(cartItem.getCartItemId());
	}*/
	
	public void updateQuantity(CartItem cartItem) {
	     cartItemMapper.updateByCartItemId(cartItem);
	}
	
}
