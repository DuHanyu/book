package com.gk.hgx.bean;

import java.math.BigDecimal;

public class CartItem {

	private Integer cartItemId;
	private Integer quantity;
	private Book book;
	private User user;
	private Integer orderBy;
	
	
	public double getSubTotal() {
		System.out.println(book.getCurrPrice()+"===="+quantity);
		BigDecimal b1=new BigDecimal(book.getCurrPrice()+"");
		BigDecimal b2=new BigDecimal(quantity+"");
		BigDecimal b3=b1.multiply(b2);
		return b3.doubleValue();
	}
	

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public CartItem(Integer cartItemId, Integer quantity, Book book, User user, Integer orderBy) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.book = book;
		this.user = user;
		this.orderBy = orderBy;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", book=" + book + ", user=" + user
				+ ", orderBy=" + orderBy + "]";
	}




}
