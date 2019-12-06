package com.address.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Address;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;

public class AddressDao {
	
	
	//添加地址
	public boolean add(Address address) throws SQLException {
		
		String valuesName = "UserId,name,phoneNumber,address,more,postalCode";
		String values = address.getUserId()+","
				+address.getName()+","
				+address.getPhoneNumber()+","
				+address.getAddress()+","
				+address.getMore()+","
				+address.getPostalCode();
		
		Boolean f = false;//操作结果
		int i = 0;
		java.sql.Connection connection = null;
		PreparedStatement pstm = null;
		
		connection = DbUtil.getCon();
		String sql = String.format("insert into tbl_address"
				+ " (%s) values (%s)",valuesName,values);
		//取消自动提交
		connection.setAutoCommit(false);
		pstm = connection.prepareStatement(sql);
		i = pstm.executeUpdate();
		pstm.close();
		connection.commit();
		if(i!=0)
			f = true;
		else
			f = false;
		
		return f;
		
	}
	
	// 删除地址
	public boolean del(Address address) throws SQLException {
		
		Boolean f = false;//操作结果
		int i = 0;
		java.sql.Connection connection = null;
		PreparedStatement pstm = null;
		
		connection = DbUtil.getCon();
		String sql = "delete from tbl_address where id="+"'"+address.getId()+"'";
		//取消自动提交
		connection.setAutoCommit(false);
		pstm = connection.prepareStatement(sql);
		i = pstm.executeUpdate();
		pstm.close();
		connection.commit();
		if(i!=0)
			f = true;
		else
			f = false;
		
		return f;
		
	}

	//修改地址
	public boolean update(Address address) throws SQLException {
		
		Boolean f = false;//操作结果
		int i = 0;
		java.sql.Connection connection = null;
		PreparedStatement pstm = null;
		
		connection = DbUtil.getCon();
		String sql = String.format("update tbl_address set "
				+ "name='%s',phoneNumber='%s',address='%s',more='%s',"
				+ "postalCode='%s'",address.getName(),address.getPhoneNumber(),address.getAddress(),address.getMore(),address.getPostalCode());
		//取消自动提交
		connection.setAutoCommit(false);
		pstm = connection.prepareStatement(sql);
		i = pstm.executeUpdate();
		pstm.close();
		connection.commit();
		if(i!=0)
			f = true;
		else
			f = false;
		
		return f;
	}
	
	//通过UserId查询
	public List<Address> searchByUserId(int UserId) throws SQLException{
		List<Address> addresslist = new ArrayList<Address>();
		String sql = "select * from tbl_address where UserId = "+UserId;
		Address a = null;
		java.sql.Connection connection = null;
		PreparedStatement pstm = null;
		
		connection = DbUtil.getCon();
		//取消自动提交
		connection.setAutoCommit(false);
		pstm = connection.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			int Id = rs.getInt("Id");
			String name = rs.getString("name");
			String phoneNumber = rs.getString("phoneNumber");
			String address = rs.getString("address");
			String more = rs.getString("more");
			String postalCode = rs.getString("postalCode");
			a = new Address(UserId, Id, name, phoneNumber, address, more, postalCode);
			addresslist.add(a);
			
		}
		
		pstm.close();
		connection.commit();
		return addresslist;
	}
	//通过Id查询
	public Address searchById(int Id) throws SQLException {
		Address a = null;
		String sql = "select * from tbl_address where Id = "+Id;
		java.sql.Connection connection = null;
		PreparedStatement pstm = null;
		connection = DbUtil.getCon();
		//取消自动提交
		connection.setAutoCommit(false);
		pstm = connection.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		int UserId = rs.getInt("UserId");
		String name = rs.getString("name");
		String phoneNumber = rs.getString("phoneNumber");
		String address = rs.getString("address");
		String more = rs.getString("more");
		String postalCode = rs.getString("postalCode");
		a = new Address(UserId, Id, name, phoneNumber, address, more, postalCode);
		
		return a;
		
		
	}

}
