package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;
import com.entity.User;
import com.util.DbUtil;

public class UserDao {
	public Boolean patientRegister(String valuesName,String values){
		Connection con = null;
		PreparedStatement pstm = null;
		int i = 0 ;
		try{
			con = DbUtil.getCon();
			String sql = String.format("insert into tbl_user (%s) values (%s)",valuesName,values);
			//取消自动提交
			con.setAutoCommit(false);
			pstm = con.prepareStatement(sql);
			i = pstm.executeUpdate();
			pstm.close();
			con.commit();
			if(i!=0)
				return true;
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		return false;
	}
	
	public Boolean doctorRegister(String valuesName,String values){
		Connection con = null;
		PreparedStatement pstm = null;
		int i = 0;
		try{
			con = DbUtil.getCon();
			String sql = String.format("insert into tbl_doctor (%s) values (%s)",valuesName,values);
			//取消自动提交
			con.setAutoCommit(false);
			pstm = con.prepareStatement(sql);
			i = pstm.executeUpdate();
			pstm.close();
			con.commit();
			if(i!=0)
				return true;
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		return false;
		
	}
	
	public User userLogin(String phone,String password){
		Connection con = null;
		try {
			con = DbUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from tbl_user where"
					+ " phone = ? and password = ?");
			pstm.setString(1, phone);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setNickName(rs.getString(2));;
				user.setPhone(phone);
				user.setPassword(password);
				user.setPID(rs.getString(5));
				user.setHeadImg(rs.getString(6));
				user.setAddress(rs.getString(7));
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		return null;
	}
	
	public Doctor doctorLogin(String phone,String password){
		Connection con = null;
		try{
			con = DbUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from tbl_doctor where"
					+ " phone = ? and password = ?");
			pstm.setString(1, phone);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setPhone(phone);
				doctor.setAddress(rs.getString(4));
				doctor.setPassword(password);
				doctor.setPID(rs.getString(6));
				doctor.setHospital(rs.getString(7));
				doctor.setLicence1(rs.getString(8));
				doctor.setHeadImg(rs.getString(9));
				doctor.setLicence2(rs.getString(10));
				return doctor;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		return null;
	}
}
