package com.gk.hgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.Book;
import com.gk.hgx.mapper.BookMapper;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> findSelectBook(Book book) {
		return bookMapper.findSelectBook(book);
	}

	public Book load(Integer bid) {
		  return bookMapper.load(bid);
	}
	
	public int getCountByCid(Integer cid) {
		Integer count=bookMapper.getCountByCid(cid);
		return count==null?0:count.intValue();
	}

	public void add(Book book) {
       bookMapper.add(book);		
	}

	public void update(Book book) {
       bookMapper.update(book);		
	}

	public void delete(Book book) {
		bookMapper.delete(book);
	}
}
