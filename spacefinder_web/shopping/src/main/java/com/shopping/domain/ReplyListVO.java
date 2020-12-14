package com.shopping.domain;

import java.util.Date;

public class ReplyListVO {
	
	private String GP_id;
	private String username;
	private String GP_content;
	private Date GP_date;
	
	public String getGP_id() {
		return GP_id;
	}
	public void setGP_id(String gP_id) {
		GP_id = gP_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGP_content() {
		return GP_content;
	}
	public void setGP_content(String gP_content) {
		GP_content = gP_content;
	}
	public Date getGP_date() {
		return GP_date;
	}
	public void setGP_date(Date gP_date) {
		GP_date = gP_date;
	}
	
}
