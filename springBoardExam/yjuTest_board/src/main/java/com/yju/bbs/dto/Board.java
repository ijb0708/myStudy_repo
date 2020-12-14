package com.yju.bbs.dto;

import java.sql.Timestamp;

public class Board {
	
	private int idx;
	private String title;
	private String cont;
	private Timestamp put_date;
	private String userid;
	private int man_hit;
	private int nor_hit;
	private int man_like;
	private int nor_like;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Timestamp getPut_date() {
		return put_date;
	}
	public void setPut_date(Timestamp put_date) {
		this.put_date = put_date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getMan_hit() {
		return man_hit;
	}
	public void setMan_hit(int man_hit) {
		this.man_hit = man_hit;
	}
	public int getNor_hit() {
		return nor_hit;
	}
	public void setNor_hit(int nor_hit) {
		this.nor_hit = nor_hit;
	}
	public int getMan_like() {
		return man_like;
	}
	public void setMan_like(int man_like) {
		this.man_like = man_like;
	}
	public int getNor_like() {
		return nor_like;
	}
	public void setNor_like(int nor_like) {
		this.nor_like = nor_like;
	}
}
