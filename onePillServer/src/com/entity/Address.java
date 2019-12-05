package com.entity;

//地址类
public class Address {
	private int UserId;
    private int Id;
    private String name;
    private String phoneNumber;
    private String address;
    private String more;
    private String postalCode;

    public Address(int UserId,String name,String phoneNumber,String address,String more,String postalCode){
        this.UserId = UserId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.more = more;
        this.postalCode = postalCode;
    }

    public Address(int userId2, int id2, String name2, String phoneNumber2, String address2, String more2,
			String postalCode2) {
		// TODO Auto-generated constructor stub
    	this.UserId = userId2;
    	this.Id = id2;
        this.name = name2;
        this.phoneNumber = phoneNumber2;
        this.address = address2;
        this.more = more2;
        this.postalCode = postalCode2;
	}

	public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
