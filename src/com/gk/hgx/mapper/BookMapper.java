package com.gk.hgx.mapper;

import java.util.List;

import com.gk.hgx.bean.Book;

public interface BookMapper {
   
	
	public List<Book> findSelectBook(Book book);

	public Book load(Integer bid);
	
	public int getCountByCid(Integer cid);//获取某一分类下图书的数量

	public void add(Book book);

	public void update(Book book);//根据bid修改book

	public void delete(Book book);//根据bid删除book
	
	
}
