package com.cart.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.cart.service.CartService;
import com.entity.Cart;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 1. 读取传过来要添加的购物车数据
		InputStream is = request.getInputStream();
		StringBuffer sb = new StringBuffer();
		byte[] temp = new byte[255];
		int len;
		while((len = is.read(temp))!=-1){
			sb.append(new String(temp,0,len));
		}
		String accept = new String(sb);
		// 2. 将读取的内容转化为 JSON格式,在转化成cart对象
		JSONObject newCart = new JSONObject(accept);
		Cart cart = new Cart();
		cart.setUserid(newCart.getInt("userid"));
		cart.setCount(newCart.getInt("count"));
		cart.setMedicineid(newCart.getInt("medicineid"));
		cart.setPrice(newCart.getInt("price"));
		cart.setMedicineName(newCart.getString("medicineName"));
		cart.setMedicineSize(newCart.getString("medicineSize"));
		// 3. 将获取的新的购物车内容放入数据库
		CartService cartService = new CartService();
		int i =cartService.addIntoCart(cart);
		// 4. 返回响应
		JSONObject retJson = new JSONObject();
		if(i>0){
			retJson.put("addFinish", true);
		}else{
			retJson.put("addFinish", false);
		}
		OutputStream os = response.getOutputStream();
		os.write(retJson.toString().getBytes());
		os.close();
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
