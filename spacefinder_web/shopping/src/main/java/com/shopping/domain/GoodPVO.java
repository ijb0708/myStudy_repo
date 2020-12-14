package com.shopping.domain;

import java.util.Date;

public class GoodPVO {
	/*
	 * create table GoodPlace (
    GP_id       varchar2(20)          not null,
    userId VARCHAR(50) not null,
    GP_name      varchar2(20)    not null,
    GP_category     varchar2(20)    not null,
    GP_lat    VARCHAR2(50)          not null,
    GP_long     VARCHAR2(50)        null,
    GP_Runtime       varchar(20)    null,
    GP_content       varchar(1000)    null,
    GP_image      varchar(50)           null,
    GP_click number(6) DEFAULT 0,
    GP_restday varchar(20) null,
    GP_parking varchar(100) null,
    primary key(GP_id),
    foreign key(userId) references tbl_member(userId)
);
	 */
	
	private String GP_id;
	private String userId;
	private String GP_name;
	private String GP_category;
	private String GP_lat;
	private String GP_long;
	private String GP_Runtime;
	private String GP_content;
	private String GP_click;
	private String GP_restday;
	private String GP_parking;
	private Date GP_date;
	private String GP_image1;
	private String GP_image2;
	private String GP_image3;
	private String GP_image4;
	
	private String GP_ThumbImg1;
	private String GP_ThumbImg2;
	private String GP_ThumbImg3;
	private String GP_ThumbImg4;
	
	private String GP_slot;
	private String GP_basetime;
	private String GP_basepay;
	private String GP_overtime;
	private String GP_overpay;
	private String GP_onepay;
	private String GP_monthpay;
	
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

	public String getGP_name() {
		return GP_name;
	}

	public void setGP_name(String gP_name) {
		GP_name = gP_name;
	}

	public String getGP_category() {
		return GP_category;
	}

	public void setGP_category(String gP_category) {
		GP_category = gP_category;
	}

	public String getGP_lat() {
		return GP_lat;
	}

	public void setGP_lat(String gP_lat) {
		GP_lat = gP_lat;
	}

	public String getGP_long() {
		return GP_long;
	}

	public void setGP_long(String gP_long) {
		GP_long = gP_long;
	}

	public String getGP_Runtime() {
		return GP_Runtime;
	}

	public void setGP_Runtime(String gP_Runtime) {
		GP_Runtime = gP_Runtime;
	}

	public String getGP_content() {
		return GP_content;
	}

	public void setGP_content(String gP_content) {
		GP_content = gP_content;
	}

	public String getGP_click() {
		return GP_click;
	}

	public void setGP_click(String gP_click) {
		GP_click = gP_click;
	}

	public String getGP_restday() {
		return GP_restday;
	}

	public void setGP_restday(String gP_restday) {
		GP_restday = gP_restday;
	}

	public String getGP_parking() {
		return GP_parking;
	}

	public void setGP_parking(String gP_parking) {
		GP_parking = gP_parking;
	}

	public Date getGP_date() {
		return GP_date;
	}

	public void setGP_date(Date gP_date) {
		GP_date = gP_date;
	}

	public String getGP_image1() {
		return GP_image1;
	}

	public void setGP_image1(String gP_image1) {
		GP_image1 = gP_image1;
	}

	public String getGP_image2() {
		return GP_image2;
	}

	public void setGP_image2(String gP_image2) {
		GP_image2 = gP_image2;
	}

	public String getGP_image3() {
		return GP_image3;
	}

	public void setGP_image3(String gP_image3) {
		GP_image3 = gP_image3;
	}

	public String getGP_image4() {
		return GP_image4;
	}

	public void setGP_image4(String gP_image4) {
		GP_image4 = gP_image4;
	}

	public String getGP_ThumbImg1() {
		return GP_ThumbImg1;
	}

	public void setGP_ThumbImg1(String gP_ThumbImg1) {
		GP_ThumbImg1 = gP_ThumbImg1;
	}

	public String getGP_ThumbImg2() {
		return GP_ThumbImg2;
	}

	public void setGP_ThumbImg2(String gP_ThumbImg2) {
		GP_ThumbImg2 = gP_ThumbImg2;
	}

	public String getGP_ThumbImg3() {
		return GP_ThumbImg3;
	}

	public void setGP_ThumbImg3(String gP_ThumbImg3) {
		GP_ThumbImg3 = gP_ThumbImg3;
	}

	public String getGP_ThumbImg4() {
		return GP_ThumbImg4;
	}

	public void setGP_ThumbImg4(String gP_ThumbImg4) {
		GP_ThumbImg4 = gP_ThumbImg4;
	}

	public String getGP_slot() {
		return GP_slot;
	}

	public void setGP_slot(String gP_slot) {
		GP_slot = gP_slot;
	}

	public String getGP_basetime() {
		return GP_basetime;
	}

	public void setGP_basetime(String gP_basetime) {
		GP_basetime = gP_basetime;
	}

	public String getGP_basepay() {
		return GP_basepay;
	}

	public void setGP_basepay(String gP_basepay) {
		GP_basepay = gP_basepay;
	}

	public String getGP_overtime() {
		return GP_overtime;
	}

	public void setGP_overtime(String gP_overtime) {
		GP_overtime = gP_overtime;
	}

	public String getGP_overpay() {
		return GP_overpay;
	}

	public void setGP_overpay(String gP_overpay) {
		GP_overpay = gP_overpay;
	}

	public String getGP_onepay() {
		return GP_onepay;
	}

	public void setGP_onepay(String gP_onepay) {
		GP_onepay = gP_onepay;
	}

	public String getGP_monthpay() {
		return GP_monthpay;
	}

	public void setGP_monthpay(String gP_monthpay) {
		GP_monthpay = gP_monthpay;
	}

	public String getGP_REF_ID() {
		return GP_REF_ID;
	}

	public void setGP_REF_ID(String gP_REF_ID) {
		GP_REF_ID = gP_REF_ID;
	}

	
}
