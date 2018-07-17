package com.gk.hgx.bean;

public class Admin {

	private Integer aid;
	private String adminname;
	private String adminpwd;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", adminname=" + adminname + ", adminpwd=" + adminpwd + "]";
	}



}
