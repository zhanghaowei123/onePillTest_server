package com.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Doctor;
import com.entity.User;
import com.google.gson.Gson;
import com.user.service.UserService;

/**
 * Servlet implementation class RegisterDoctorServlet
 */
@WebServlet("/RegisterDoctorServlet")
public class RegisterDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		InputStream is = request.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuffer stringBuffer=new StringBuffer();
        String str=null;
        while((str=reader.readLine()) != null) {
            stringBuffer.append(str);
        }
        Gson gson=new Gson();
        Doctor newDoctor = gson.fromJson(stringBuffer.toString(),Doctor.class);
        Boolean isSuccessful = new UserService().RegisterDoctorService("name,phone,address,password,PID,"
        		+ "hospital,licence1,headImg,licence2", "'"+newDoctor.getName()+"','"+newDoctor.getPhone()
        		+"','"+newDoctor.getAddress()+"','"+newDoctor.getPassword()+"','"+newDoctor.getPID()+"','"+newDoctor.getHospital()
        		+"','"+null+"','"+null+"','"+null+"'");
        if(isSuccessful){
			String result = gson.toJson(true);
			System.out.println("医生注册成功！");
			response.getWriter().append(result);
			
		}else{
			String result = gson.toJson(false);
			System.out.println("医生注册失败！");
			response.getWriter().append(result);
		}
        
	}

}
