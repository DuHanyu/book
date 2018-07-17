package com.gk.hgx.controll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gk.hgx.bean.CartItem;
import com.gk.hgx.bean.User;
import com.gk.hgx.service.CartItemService;

@Controller
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/myCart")
	public String myCart(Map<String,Object> map,HttpSession session) {
		map.put("myCart", cartItemService.myCart(((User)session.getAttribute("user")).getUid()));
		return "jsps/cart/list";
	}
	
	@RequestMapping("/updateQuantity")
	@ResponseBody
	public Map<String,Object> updateQuantity(CartItem cartItem) {
		System.out.println("+++++++++   updateQuantity     ++++++++");
		System.out.println(cartItem);
		cartItemService.updateQuantity(cartItem);
		Map<String,Object> map=new HashMap<>();
		map.put("subtotal", cartItem.getSubTotal());
		map.put("quantity", cartItem.getQuantity());
		return map;
	}



	
	
	@RequestMapping("/add")
	public String add(CartItem cartItem,HttpSession session) {
		System.out.println(cartItem);
		User user=(User)session.getAttribute("user");
		System.out.println(user);
		cartItem.setUser(user);
		cartItemService.add(cartItem);
		return "forward:/myCart";
	}
	
	@RequestMapping("/delete")
	public String batchDelete(@RequestParam("cartItemIds") String cartItemIds,@RequestParam("uid") Integer uid) {
		System.out.println(cartItemIds);
		String [] ids=cartItemIds.split(",");
		Integer [] ids2=new Integer[ids.length];
       for(int i=0;i<ids.length;i++) {
    	   ids2[i]=Integer.parseInt(ids[i]);
       }
		List<Integer> lists=new ArrayList();
		lists=Arrays.asList(ids2);
		cartItemService.batchDelete(lists);
		return "forward:/myCart";
	}
	
	@RequestMapping("/loadCartItems")
	public String loadCartItems(@RequestParam("cartItemIds") String cartItemIds,Map<String,Object> map) {
		String [] ids=cartItemIds.split(",");
		Integer [] ids2=new Integer[ids.length];
       for(int i=0;i<ids.length;i++) {
    	   ids2[i]=Integer.parseInt(ids[i]);
       }
		List<Integer> lists=new ArrayList();
		lists=Arrays.asList(ids2);
		
		List<CartItem> cartItemList=cartItemService.findByCartItemIds(lists);
		map.put("cartItemList", cartItemList);
		map.put("cartItemIds", cartItemIds);
		return "jsps/cart/showitem";
	}
	
	
	
}
