package Beans;

import java.sql.Timestamp;

public class itemBean {


	private String item_code;
	private String name;
	private String thum_pic;
	private String dtail_pic;
	private int price;
	private int remain;
	private Timestamp start_time;
	private Timestamp end_time;
	private String dscript;
	
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThum_pic() {
		return thum_pic;
	}
	public void setThum_pic(String thum_pic) {
		this.thum_pic = thum_pic;
	}
	public String getDtail_pic() {
		return dtail_pic;
	}
	public void setDtail_pic(String dtail_pic) {
		this.dtail_pic = dtail_pic;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getDscript() {
		return dscript;
	}
	public void setDscript(String dscript) {
		this.dscript = dscript;
	}
	
}
