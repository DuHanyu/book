package com.gk.hgx.controll;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.hgx.bean.Category;
import com.gk.hgx.service.BookService;
import com.gk.hgx.service.CategoryService;

@Controller
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/findAll")
	public String findAll(Map<String, Object> map) {

		List<Category> allPartentList = categoryService.getAllPartentList();
		map.put("categoryList", allPartentList);
		return "adminjsps/admin/category/list";
	}

	@RequestMapping("/addParentPre")
	public String addParentPre() {
		return "adminjsps/admin/category/add";
	}

	@RequestMapping("/addParent")
	public String addParent(Category category) {
		categoryService.add(category);
		return "forward:/findAll";
	}

	@RequestMapping("/addChildPre/{cid}")
	public String addChildPre(@PathVariable("cid") Integer cid, Map<String, Object> map) {

		List<Category> allPartentList = categoryService.getAllPartentList();
		map.put("parents", allPartentList);
		map.put("cid", cid);
		return "adminjsps/admin/category/add2";
	}

	@RequestMapping("/addChild")
	public String addChild(Category category) {
		categoryService.add(category);
		return "forward:/findAll";
	}

	@RequestMapping("/editParentPre/{cid}")
	public String editParentPre(@PathVariable("cid") Integer cid, Map<String, Object> map) {
		Category category = categoryService.get(cid);
		map.put("category", category);
		return "adminjsps/admin/category/edit";
	}

	@RequestMapping("/editParent")
	public String editParent(Category category) {
		categoryService.update(category);
		return "forward:/findAll";
	}
	
	
	@RequestMapping("/editChildPre/{cid}")
	public String editChildPre(@PathVariable("cid") Integer cid, Map<String, Object> map) {
		List<Category> allPartentList = categoryService.getAllPartentList();
		map.put("parents", allPartentList);
		Category category = categoryService.get(cid);
		map.put("category", category);
		return "adminjsps/admin/category/edit2";
	}

	@RequestMapping("/editChild")
	public String editChild(Category category) {
		categoryService.update(category);
		return "forward:/findAll";
	}
	
	@RequestMapping("/deleteParent/{cid}")
	public String deleteParent(@PathVariable("cid") Integer cid,Map<String,Object> map) {
		
		int count =categoryService.getCountChild(cid);
		if(count>0) {
			map.put("msg", "该一级分类下还有二级分类，所以不能删除");
			return "/adminjsps/admin/msg";
		}else {
			categoryService.delete(cid);
			return "forward:/findAll";
		}
		
	}
	
	@RequestMapping("/deleteChild/{cid}")
	public String deleteChild(@PathVariable("cid") Integer cid,Map<String,Object> map) {
		int count=bookService.getCountByCid(cid);
		if(count>0) {
			map.put("msg", "该分类下还有图书，所以不能删除");
			return "/adminjsps/admin/msg";
		}else {
			categoryService.delete(cid);
			return "forward:/findAll";
		}
	}

}
