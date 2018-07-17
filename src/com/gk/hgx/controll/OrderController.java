package com.gk.hgx.controll;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gk.hgx.bean.CartItem;
import com.gk.hgx.bean.Order;
import com.gk.hgx.bean.OrderItem;
import com.gk.hgx.bean.User;
import com.gk.hgx.service.CartItemService;
import com.gk.hgx.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartItemService cartItemService;
	
	
	@RequestMapping("/userCancel")
	public String cancel(@RequestParam("oid") Integer oid,Map<String,Object> map) {
		
		Order order = orderService.get(oid);
		if(order.getStatus()!=1) {
			map.put("code", "error");
			map.put("msg", "状态不对，不能取消");
		}else {
			orderService.updateOrderStatus(oid,5);
			map.put("code", "success");
			map.put("msg", "取消成功");
		}
		
		return "jsps/msg";
	}
	
	@RequestMapping("/userConfirm")
	public String confirm(@RequestParam("oid") Integer oid,Map<String,Object> map) {
		
		Order order = orderService.get(oid);
		if(order.getStatus()!=3) {
			map.put("code", "error");
			map.put("msg", "状态不对，不能确认");
		}else {
			orderService.updateOrderStatus(oid,4);
			map.put("code", "success");
			map.put("msg", "确认成功");
		}
		
		return "jsps/msg";
	}
	

	@RequestMapping("/aa")
	public String create2(@RequestParam("address") String address, @RequestParam("ids") String ids, HttpSession session,
			Map<String, Object> map) {
		String[] id = ids.split(",");
		Integer[] ids2 = new Integer[id.length];
		for (int i = 0; i < id.length; i++) {
			ids2[i] = Integer.parseInt(id[i]);
		}
		List<Integer> lists = new ArrayList();
		lists = Arrays.asList(ids2);
		List<CartItem> findByCartItemIds = cartItemService.findByCartItemIds(lists);
		List<OrderItem> orderItemList = new ArrayList<>();

		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setOid(null);
		order.setAddress(address);
		order.setOrdertime(String.format("%tF %<tT", new Date()));
		order.setStatus(1);
		order.setUser(user);
		BigDecimal b1 = new BigDecimal("0");
		for (int i = 0; i < findByCartItemIds.size(); i++) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setBook(findByCartItemIds.get(i).getBook());
			orderItem.setOrderItemId(null);
			orderItem.setQuantity(findByCartItemIds.get(i).getQuantity());
			orderItem.setSubtotal(findByCartItemIds.get(i).getSubTotal());
			BigDecimal b2 = new BigDecimal(findByCartItemIds.get(i).getSubTotal() + "");
			b1 = b1.add(b2);
			orderItemList.add(orderItem);
		}
		order.setTotal(b1.doubleValue());
		order.setOrderItemList(orderItemList);
		order = orderService.createOrder(order);
		cartItemService.batchDelete(lists);
		map.put("order", order);
		return "jsps/order/ordersucc";
	}

	@RequestMapping("/queryOrder")
	public String queryOrder(@RequestParam("oid") Integer oid,
			@RequestParam(value = "btn", required = false) String btn, Map<String, Object> map) {

		map.put("btn", btn);
		Order order = orderService.get(oid);
		System.out.println(order);
		map.put("order", order);
		return "jsps/order/desc";
	}

	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request,
			@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage) {

		Integer uid = ((User) (request.getSession().getAttribute("user"))).getUid();
		PageHelper.startPage(currPage, 2);
		List<Order> myOrderList = orderService.myOrder(uid);
		PageInfo<Order> pageInfo = new PageInfo<>(myOrderList, 6);
		System.out.println(pageInfo.getList());
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("url", getUrl(request));
		return "jsps/order/list";
	}

	public String getUrl(HttpServletRequest request) {

		String url = request.getRequestURI() + "?" + request.getQueryString();
		int index = url.lastIndexOf("&currPage=");
		if (index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}

}
