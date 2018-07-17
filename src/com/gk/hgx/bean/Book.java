package com.gk.hgx.bean;

public class Book {
	
	private Integer bid;
	private String bname;
	private String author;
	private Double price;
	private Double currPrice;
	private Double discount;
	private String press;
	private String publishtime;
	private Integer edition;
	private Integer pageNum;
	private Integer wordNum;
	private String printtime;
	private Integer booksize;
	private String paper;
	private Category category;
	private String image_w;
	private String image_b;
	private Integer orderBy;
	

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(Double currPrice) {
		this.currPrice = currPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getWordNum() {
		return wordNum;
	}

	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}

	public String getPrinttime() {
		return printtime;
	}

	public void setPrinttime(String printtime) {
		this.printtime = printtime;
	}

	public Integer getBooksize() {
		return booksize;
	}

	public void setBooksize(Integer booksize) {
		this.booksize = booksize;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImage_w() {
		return image_w;
	}

	public void setImage_w(String image_w) {
		this.image_w = image_w;
	}

	public String getImage_b() {
		return image_b;
	}

	public void setImage_b(String image_b) {
		this.image_b = image_b;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", price=" + price + ", currPrice="
				+ currPrice + ", discount=" + discount + ", press=" + press + ", publishtime=" + publishtime
				+ ", edition=" + edition + ", pageNum=" + pageNum + ", wordNum=" + wordNum + ", printtime=" + printtime
				+ ", booksize=" + booksize + ", paper=" + paper + ", category=" + category + ", image_w=" + image_w
				+ ", image_b=" + image_b + ", orderBy=" + orderBy + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bid, String bname, String author, Double price, Double currPrice, Double discount, String press,
			String publishtime, Integer edition, Integer pageNum, Integer wordNum, String printtime, Integer booksize,
			String paper, Category category, String image_w, String image_b, Integer orderBy) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.currPrice = currPrice;
		this.discount = discount;
		this.press = press;
		this.publishtime = publishtime;
		this.edition = edition;
		this.pageNum = pageNum;
		this.wordNum = wordNum;
		this.printtime = printtime;
		this.booksize = booksize;
		this.paper = paper;
		this.category = category;
		this.image_w = image_w;
		this.image_b = image_b;
		this.orderBy = orderBy;
	}

}
