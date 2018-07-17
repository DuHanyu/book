package com.gk.hgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.Category;
import com.gk.hgx.mapper.CategoryMapper;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public List<Category> getAllPartentList() {
		return categoryMapper.getAllPartentList();
	}

	public void add(Category category) {
		categoryMapper.add(category);
	}

	public Category get(Integer cid) {
		return categoryMapper.get(cid);
	}

	public void update(Category category) {
		categoryMapper.update(category);
	}

	public int getCountChild(Integer cid) {
		Integer count=categoryMapper.getCountChild(cid);
		return count==null?0:count.intValue();
	}

	public void delete(Integer cid) {
		categoryMapper.delete(cid);
	}
	
	public List<Category> getAllParentNotChildList(){
		return categoryMapper.getAllParentNotChildList();
	}
	
	public List<Category> getEveryParentAllChildList(Category category){
		return categoryMapper.getEveryParentAllChildList(category);
	}

}
