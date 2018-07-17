package com.gk.hgx.mapper;

import java.util.List;

import com.gk.hgx.bean.Category;

public interface CategoryMapper {
  
	public List<Category> getAllPartentList();
	
	public List<Category> getEveryParentAllChildList(Category category);
	
	public void add(Category category);
	
	public Category get(Integer cid);

	
	public void update(Category category);

	public int getCountChild(Integer cid);//获取父分类下子分类的个数
	
	public void delete(Integer cid);//根据cid删除某一分类
	
	public List<Category> getAllParentNotChildList();
	
	
}
