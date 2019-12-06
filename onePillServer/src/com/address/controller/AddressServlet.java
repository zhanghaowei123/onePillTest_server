package com.address.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Address;
import com.google.gson.Gson;
import com.address.dao.AddressDao;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private boolean f = false;
	private AddressDao dao = new AddressDao();
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.print("地址服务器");
		String code = request.getParameter("Code");
		switch (code) {
		case "add":
			//添加地址
			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String more = request.getParameter("more");
			String postalCode = request.getParameter("postalCode");
			String userIdString = request.getParameter("UserId");
			int UserId = Integer.valueOf(userIdString);
			Address address2 = new Address(UserId, name, phoneNumber, address, more, postalCode);
			/* AddressDao dao = new AddressDao(); */
			//存入数据库
			try {
				f = dao.add(address2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (f) {
				response.getWriter().append("yes");
			}else {
				response.getWriter().append("no");
			}
			break;
			//查询所有地址
		case "searchAll":
			
			int userId = Integer.parseInt(request.getParameter("UserId"));
			List<Address> addressList = new ArrayList<Address>();
			try {
				addressList = dao.searchByUserId(userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().append(null);
			}
			response.getWriter().append(gson.toJson(addressList));
			break;
			

		default:
			break;
		}
		
	}

}
