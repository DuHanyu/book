package com.gk.hgx.bean;

import java.util.List;

public class Category {

	private Integer cid;
	private String cname;
	private String miaoshu;
	private Integer orderBy;
	private Category parent;
	private List<Category> childs;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}




	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChilds() {
		return childs;
	}

	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", miaoshu=" + miaoshu + ", orderBy=" + orderBy
				+ ", parent=" + parent + ", childs=" + childs + "]";
	}



}
