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

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
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
		// 1. 获取传递过来的 CakeId
		InputStream is = request.getInputStream();
		byte[] temp = new byte[255];
		int len = is.read(temp);
		String get = new String(temp,0,len);
		JSONObject object = new JSONObject(get);
		int cakeId = object.getInt("cakeId");
		// 2. 查询出该 id 对应的Cake信息
//		Med cake = new BuyerServiceImp().findCakeById(cakeId);
		// 3. 将信息发送给客户端
		OutputStream os = response.getOutputStream();
		JSONObject send = new JSONObject();
	
		os.write(send.toString().getBytes());
		
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
