package com.shopping.domain;

import java.util.Date;

public class ReplyVO {
	
	private String GP_id;
	private String userId;
	private String GP_content;
	private Date GP_date;
	private String GP_REF_ID;
	
	public String getGP_id() {
		return GP_id;
	}
	public void setGP_id(String gP_id) {
		GP_id = gP_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getGP_REF_ID() {
		return GP_REF_ID;
	}
	public void setGP_REF_ID(String gP_REF_ID) {
		GP_REF_ID = gP_REF_ID;
	}
	
	
}
