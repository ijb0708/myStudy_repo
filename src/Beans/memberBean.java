package Beans;

public class memberBean {
	
	private String id;
	private String pwd;
	private String email;
	private int hp;
	private int scial_num;
	private String name;
	private String isMan;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScial_num() {
		return scial_num;
	}
	public void setScial_num(int scial_num) {
		this.scial_num=scial_num;
	}
	public String getIsMan() {
		return isMan;
	}
	public void setIsMan(String isMan) {
		this.isMan = isMan;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

