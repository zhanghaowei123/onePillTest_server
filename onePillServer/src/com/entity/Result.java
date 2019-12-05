package com.entity;

public class Result {
	private User user;
	private int code; //1.登录成功 2.电话不存在 3.密码错误
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}	
