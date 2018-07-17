package com.gk.hgx.mapper;

import java.util.List;

import com.gk.hgx.bean.CartItem;

public interface CartItemMapper {

	public List<CartItem> myCart(Integer uid);

	public CartItem queryByUidAndBid(CartItem cartItem);

	public void add(CartItem cartItem);

	public void updateByCartItemId(CartItem cartItem);
	
	
	public void batchDelete(List<Integer> lists);
	
	public List<CartItem> findByCartItemIds(List<Integer> cartItemIds);
	
	public CartItem findByCartItemId(Integer cartItemId);
	
	
}
