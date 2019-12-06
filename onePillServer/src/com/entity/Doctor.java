package com.entity;

public class Doctor {
	private int doctorId;
	private String name;
	private String phone;
	private String address;
	private String password;
	private String PID;
	private String hospital;
	private String headImg;
	private String licence1;
	private String licence2;
	
	
	
	public Doctor() {
		
	}
	public Doctor(String name, String phone, String address, String password, String pID, String hospital,
			String headImg, String licence1, String licence2) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
		PID = pID;
		this.hospital = hospital;
		this.headImg = headImg;
		this.licence1 = licence1;
		this.licence2 = licence2;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getLicence1() {
		return licence1;
	}
	public void setLicence1(String licence1) {
		this.licence1 = licence1;
	}
	public String getLicence2() {
		return licence2;
	}
	public void setLicence2(String licence2) {
		this.licence2 = licence2;
	}
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", phone=" + phone + ", address=" + address + ", password="
				+ password + ", PID=" + PID + ", hospital=" + hospital + "]";
	}
}
