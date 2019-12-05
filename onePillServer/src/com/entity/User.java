package com.entity;

public class User {
	private int userId;
	private String nickName;
	private String phone;
	private String password;
	private String PID;
	private String headImg;
	private String address;
	
	public User(){
		
	}
	public User(String nickName, String phone, String password, String pID, String headImg, String address) {
		super();
		this.nickName = nickName;
		this.phone = phone;
		this.password = password;
		PID = pID;
		this.headImg = headImg;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [nickName=" + nickName + ", phone=" + phone + ", password=" + password + ", PID="
				+ PID + ", address=" + address + "]";
	}
	
}
