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
import com.gk.hgx.bean.Book;
import com.gk.hgx.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/load/{bid}")
	public String load(@PathVariable("bid") Integer bid,Map<String,Object> map) {
		Book book=bookService.load(bid);
		map.put("book", book);
		return "jsps/book/desc";
	}
	

	
	
	@RequestMapping("/findSelectBook")
	public String findSelectBook(Book book,HttpServletRequest request,@RequestParam(value="currPage",required=false)String currPage) {
		int num;
		if(currPage!=null&&!currPage.trim().isEmpty()) {
			try {
			    num=Integer.parseInt(currPage);
			} catch (Exception e) {
				num=1;
			}
		}else {
			num=1;
		}
		
		PageHelper.startPage(num, 6);
		List<Book> list=bookService.findSelectBook(book);
		PageInfo<Book> pageInfo=new PageInfo<>(list, 6);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("url", getUrl(request));
		
		return "jsps/book/list";
	}
	
	public String getUrl(HttpServletRequest request) {
		
		String url = request.getRequestURI() + "?" + request.getQueryString();
		int index = url.lastIndexOf("&currPage=");
		if(index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}
	
	
	
}
