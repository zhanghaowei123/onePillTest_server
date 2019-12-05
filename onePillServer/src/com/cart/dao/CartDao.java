package com.cart.dao;


import java.util.List;
import java.util.Map;

import com.util.DbUtil;

public class CartDao {
	private static String cartTableName = "cart";
	private static String selectAll = "*";
	private String selectAllDistinct = "distinct *";
	// 添加商品至购物车
	public static int addIntoCart(int cakeId,int buyerId,int count){
		return DbUtil.insertInto(cartTableName, "cakeId , buyerId , count",cakeId+","+buyerId+","+count);
	}
	// 根据buyerId,cakeId查询购物车中是否有对应项
	public static Map<String,Object> checkCartIsExist(String where){
		return DbUtil.findOneByWhere(selectAll, cartTableName, where);
	}
	// 根据buyerId查询所有的cartlist
	public static List<Map<String,Object>> findCartsByBuyerId(int buyerId) {
		return DbUtil.findListByWhere(selectAll, cartTableName, "buyerId ="+buyerId);
	}
	// 根据 CartId 删除某个cartItem
	public static int deleteCartById(String where){
		return DbUtil.deleteFrom(cartTableName, where);
	}
		
	// Buyer根据 CartId 修改cart中选择的数量
	public static int updateCartItemCount(String set,String where){
		return DbUtil.update(cartTableName, set, where);
	}
}