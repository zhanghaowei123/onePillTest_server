package com.entity;

public class Cart {
	private int userid;
	private int medicineid;
	private int count;
	private int price;
	private String medicineName;
	private String medicineSize;
//	public static final int SELECT_ALL = -1;			// 查询全部的状态位
//	public static final int TYPE_UNPAY = 0;         // 订单状态为 0 未付款
//    public static final int TYPE_UNSEND = 1;    // 订单状态为 1 未发货
//    public static final int TYPE_WAITGET = 2;     // 订单状态为 2 已发货
//    public static final int TYPE_FINISH = 3;        // 订单状态为 3 已完成
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMedicineid() {
		return medicineid;
	}
	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineSize() {
		return medicineSize;
	}
	public void setMedicineSize(String medicineSize) {
		this.medicineSize = medicineSize;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
