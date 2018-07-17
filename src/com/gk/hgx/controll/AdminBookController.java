package com.gk.hgx.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gk.hgx.bean.Book;
import com.gk.hgx.bean.Category;
import com.gk.hgx.service.BookService;
import com.gk.hgx.service.CategoryService;

@Controller
public class AdminBookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/ajaxChildList")
	public List<Category> ajaxChildList(Category category) {
		return categoryService.getEveryParentAllChildList(category);
	}
	
	
	@RequestMapping("/addPre")
	public String addPre(Map<String,Object> map){
		map.put("parents", categoryService.getAllParentNotChildList());
		return "adminjsps/admin/book/add";
	}
	
	@RequestMapping("/adminEdit")
	public String adminEdit(Book book,Map<String,Object> map){
		System.out.println("--------"+book);
		bookService.update(book);
		map.put("msg", "修改成功");
		return "adminjsps/admin/msg";
	}
	
	@RequestMapping("/adminDel")
	public String adminDel(Book book,HttpServletRequest request){
		System.out.println("--------"+book);
		System.out.println(request.getServletContext().getRealPath("/"));
		System.out.println(book.getImage_b());
		new File(request.getServletContext().getRealPath("/"),book.getImage_b()).delete();
		new File(request.getServletContext().getRealPath("/"),book.getImage_w()).delete();
		bookService.delete(book);
		request.setAttribute("msg", "删除成功");
		return "adminjsps/admin/msg";
	}
	
	
	@RequestMapping("/adminAdd")
	public String add(Book book,@RequestParam("file") CommonsMultipartFile file[],HttpServletRequest request,Map<String,Object> map){
		
		InputStream fileInputStream;
		OutputStream fileOutputStream;
		String[] fileName = new String[file.length];
		String path=request.getServletContext().getRealPath("/book_img");
		for(int i=0;i<file.length;i++) {
			try {
				fileInputStream=file[i].getInputStream();
				byte[] arr=new byte[2048];
				fileName[i]=UUID.randomUUID()+"_"+file[i].getOriginalFilename();
				File fi=new File(path, fileName[i].toString());
				fileOutputStream=new FileOutputStream(fi);
				int j=0;
				while((j=fileInputStream.read(arr))!=-1) {
					fileOutputStream.write(arr, 0, j);
				}
				map.put("msg", "上架成功");
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				map.put("msg", e.getMessage());
			}
		}
		
		book.setImage_w("book_img/"+fileName[0]);
		book.setImage_b("book_img/"+fileName[1]);
		bookService.add(book);
		
		return "adminjsps/admin/msg";
	}
	
	@RequestMapping("/adminFindAllParentList")
	public String adminFindAllParentList(Map<String,Object> map) {
		map.put("parents", categoryService.getAllPartentList());
		return "adminjsps/admin/book/left";
	}
	
	
	@RequestMapping("/adminLoad/{bid}")
	public String load(@PathVariable("bid") Integer bid,Map<String,Object> map) {
		Book book=bookService.load(bid);
		map.put("book", book);
		map.put("parents",categoryService.getAllParentNotChildList());
		Category category=new Category();
		System.out.println(book+"-------------");
		category.setCid(book.getCategory().getParent().getCid());
		map.put("childs",categoryService.getEveryParentAllChildList(category));
		return "adminjsps/admin/book/desc";
	}
	

	@RequestMapping("/admidFindSelectBook")
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
		
		PageHelper.startPage(num, 2);
		List<Book> list=bookService.findSelectBook(book);
		PageInfo<Book> pageInfo=new PageInfo<>(list, 6);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("url", getUrl(request));
		
		return "adminjsps/admin/book/list";
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
