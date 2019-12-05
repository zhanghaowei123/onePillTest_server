package com.cart.service;

import java.util.List;
import java.util.Map;

import com.cart.dao.CartDao;
import com.entity.Cart;
import com.util.DbUtil;

public class CartService {
	// 添加商品至购物车
	public int addIntoCart(Cart cart){
		String where = "cakeId ="+cart.getMedicineid()+" and buyerId ="+cart.getUserid();
		Map<String, Object> map = CartDao.checkCartIsExist(where);
		if (map != null) {// 说明购物车中有这个商品
			// 修改对应购物车的数量即可
			int id = (int) map.get("id");
			int count = (int) map.get("count");
			String set2 = "count ="+(count+cart.getCount());
			String where2 = "id ="+id;
			return CartDao.updateCartItemCount(set2, where2);
		}else{	// 购物车中无此商品，建立新的购物车项
			return CartDao.addIntoCart(cart.getMedicineid(), cart.getUserid(), cart.getCount());
		}
	}
	
	// 根据BuyerId 查询其所对应的 cartList
	public List<Cart> findCartsByBuyerId(int buyerId) {
		return DbUtil.changeIntoObj(Cart.class, CartDao.findCartsByBuyerId(buyerId));
	}
	// 根据CartId 删除相应的Cart信息
	public int deleteCartById(int cartId){
		String where = "id = "+cartId;
		return CartDao.deleteCartById(where);
	}
	// 根据CartId更新相应Cart中购买数量
	public int updateCartItemCount(int cartId,int newCount){
		String set = "count = "+newCount;
		String where = "id = "+cartId;
		return CartDao.updateCartItemCount(set, where);
	}
}
