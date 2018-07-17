package com.gk.hgx.controll;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gk.hgx.bean.Order;
import com.gk.hgx.bean.User;
import com.gk.hgx.service.OrderService;

@Controller
public class AdminOrderController {

	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("/updateOrderStatus")
	public String updateOrderStatus(@RequestParam("oid") Integer oid,Map<String,Object> map) {
		
		Order order = orderService.get(oid);
		if(order.getStatus()!=2) {
			map.put("msg", "状态不对，不能发货");
		}else {
			orderService.updateOrderStatus(oid,3);
			map.put("msg", "发货成功");
		}
		
		return "adminjsps/admin/msg";
	}
	
	@RequestMapping("/cancel")
	public String cancel(@RequestParam("oid") Integer oid,Map<String,Object> map) {
		
		Order order = orderService.get(oid);
		if(order.getStatus()!=1) {
			map.put("msg", "状态不对，不能取消");
		}else {
			orderService.updateOrderStatus(oid,5);
			map.put("msg", "取消成功");
		}
		
		return "adminjsps/admin/msg";
	}
	


	
	
	@RequestMapping("/adminQueryOrder")
	public String queryOrder(@RequestParam("oid") Integer oid,
			@RequestParam(value = "btn", required = false) String btn, Map<String, Object> map) {
		map.put("btn", btn);
		Order order = orderService.get(oid);
		map.put("order", order);
		return "adminjsps/admin/order/desc";
	}

	@RequestMapping("/adminFindByStatus")
	public String adminFindByStatus(HttpServletRequest request,
			@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
			@RequestParam(value = "status") Integer status) {

		PageHelper.startPage(currPage, 2);
		List<Order> findByStatus = orderService.findByStatus(status);
		PageInfo<Order> pageInfo = new PageInfo<>(findByStatus, 6);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("url", getUrl(request));
		return "adminjsps/admin/order/list";
	}

	@RequestMapping("/adminFindAll")
	public String myOrder(HttpServletRequest request,
			@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage) {

		PageHelper.startPage(currPage, 2);
		List<Order> findAll = orderService.findAll();
		PageInfo<Order> pageInfo = new PageInfo<>(findAll, 6);
		System.out.println(pageInfo.getList());
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("url", getUrl(request));
		return "adminjsps/admin/order/list";
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
