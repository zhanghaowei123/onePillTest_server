package com.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Doctor;
import com.entity.Result;
import com.entity.User;
import com.google.gson.Gson;
import com.user.service.UserService;

/**
 * Servlet implementation class DoctorLoginServlet
 */
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("医生登录");
		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		Gson gson = new Gson();
		Doctor doctor = new UserService().DoctorLoginService(phone, password);
		Result result = new Result();
		if(doctor.getPhone().equals(phone) && doctor.getPassword().equals(password)){
			result.setCode(1);
			result.setDoctor(doctor);
			String str1 = gson.toJson(result);
			System.out.println("医生登录成功！");
			response.getWriter().append(str1);
		}else if(!doctor.getPhone().equals(phone)){
			result.setCode(2);
			result.setDoctor(doctor);
			String str2 = gson.toJson(result);
			System.out.println("医生登录失败,电话错误！");
			response.getWriter().append(str2);
		}else if(!doctor.getPassword().equals(password)){
			result.setCode(3);
			result.setDoctor(doctor);
			String str3 = gson.toJson(result);
			System.out.println("医生登录失败,密码错误！");
			response.getWriter().append(str3);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
