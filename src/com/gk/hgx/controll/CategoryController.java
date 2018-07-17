package com.gk.hgx.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.hgx.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getMenu")
	public String getMenu(Map<String,Object> map) {
		
		map.put("parents", categoryService.getAllPartentList());
	   return "jsps/left";
	}
	
}
