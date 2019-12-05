package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;



public class DbUtil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @param con
	 */
	public static Connection getCon(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/onepill_db?useUnicode=true&characterEncoding=utf-8","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭数据库
	 * @param con
	 */
	public static void close(Connection con){
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 插入操作
	 * @param tableName
	 * @param valuesName
	 * @param values
	 * @return
	 */
	public static int insertInto(String tableName,String valuesName,String values){
		Connection con = null;
		java.sql.PreparedStatement pstm = null;
		ResultSet rs = null;
		int insertedId = 0;
		String sql = String.format("insert into %s (%s) values (%s);", tableName,valuesName,values);
		try {
			con = DbUtil.getCon();
			con.setAutoCommit(false);
			pstm = con.prepareStatement(sql);
			System.out.println("ִ插入sql语句："+sql);
			pstm.executeUpdate();
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbUtil.close(con);
		}
		return insertedId;
	}
	/**
	 * 删除操作
	 * @param tableName
	 * @param where
	 * @return
	 */
	public static int deleteFrom(String tableName,String where){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int i = 0;
		String sql = String.format("delete from %s where %s;", tableName,where);
		try {
			con = DbUtil.getCon();
	
			con.setAutoCommit(false);
			pstm = con.prepareStatement(sql);
			System.out.println("删除语句sql:"+sql);
			i = pstm.executeUpdate();
			pstm.close();
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbUtil.close( con);
		}
		return i;
	}
	/**
	 * 更新操作
	 * @param tableName
	 * @param set
	 * @param where
	 * @return
	 */
	public static int update(String tableName,String set,String where){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int i = 0;
		String sql = String.format("update %s set %s where %s;", tableName,set,where);
		try {
			con = DbUtil.getCon();
			con.setAutoCommit(false);
			pstm = con.prepareStatement(sql);
			System.out.println("更新操作sql为："+sql);
			i = pstm.executeUpdate();
			pstm.close();
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbUtil.close(con);
		}
		return i;
	}
	/**
	 * 查询所有
	 * @param tableName
	 * @return
	 */
	public static List<Map<String,Object>> findAll(String tableName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = String.format("select * from %s;",tableName);
		try{
			con=DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				Map<String,Object> map = new HashMap<>();
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++) {
					String colName = rsmd.getColumnLabel(i);
					map.put(colName, rs.getObject(colName));
					}
				list.add(map);
			}
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			DbUtil.close(con);
		}
	}
	/**
	 * 根据ID查询
	 * @param tableName
	 * @param id
	 * @return
	 */
	public static Map<String , Object> findById(String tableName,int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String , Object> map = new HashMap<>();
		String sql = String.format("select * from %s where id = %d;", tableName,id);
		try{
			con = DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			System.out.println("ִ根据ID查询数据:"+sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			if(rs.next()){
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++){
					String colName = rsmd.getColumnLabel(i);
					map.put(colName, rs.getObject(colName));
				}
				return map;
			}
			else{
				System.out.println("");
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			DbUtil.close(con);
		}
	}
	/**
	 * （购物车）计算总价
	 * @param tableName
	 * @return
	 */
	public static int count(String tableName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		String sql = String.format("select count(*) from %s", tableName);
		try{
		
			con = DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			System.out.println("ִcount操作执行的sql语句为:"+sql);
			rs = pstm.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DbUtil.close(con);
		}
		return count;
	}
	/**
	 * 根据where查询单个信息
	 * @param selectWhere
	 * @param tableName
	 * @param where
	 * @return
	 */
	public static Map<String , Object> findOneByWhere(String selectWhere,String tableName,String where){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String , Object> map = new HashMap<>();
		String sql = String.format("select %s from %s where %s;", selectWhere,tableName,where);
		try{
			con = DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			System.out.println("ִwhere查询执行的sql语句为:"+sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			if(rs.next()){
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++){
					String colName = rsmd.getColumnLabel(i);					
					map.put(colName, rs.getObject(colName));
				}
				return map;
			}
			else{
				System.out.println("错误");
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			DbUtil.close(con);
		}
	}
	/**
	 * 
	 * @param selectName
	 * @param tableName
	 * @param where
	 * @return
	 */
	public static List<Map<String, Object>> findListByWhere(String selectName,String tableName,String where){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = String.format("select %s from %s where %s;", selectName,tableName,where);
		System.out.println(sql);
		try{
			con = DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++){
					String colName = rsmd.getColumnLabel(i);
					map.put(colName, rs.getObject(colName));
				}
				list.add(map);
			}
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		finally {
			DbUtil.close(con);
		}
	}
	public static <T> List<T> changeIntoObj(Class<T> cls,List<Map<String,Object>> originalList){
		List<T> changedList = new ArrayList<>();
		T entity = null;
		try {
			for(int i = 0;i < originalList.size();i++){
				entity = cls.newInstance();
				Map<String,Object> map = originalList.get(i);
				for(String colName:map.keySet()){
					Field field = cls.getDeclaredField(colName);
					field.setAccessible(true);
					field.set(entity, map.get(colName));
				}
				changedList.add(entity);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return changedList;
	}
	public static <T> T changeIntoObj(Class<T> cls,Map<String,Object> originalMap){
		T entity = null;
		try {
			entity = cls.newInstance();
			for(String colName:originalMap.keySet()){
				Field field = cls.getDeclaredField(colName);
				field.setAccessible(true);
				field.set(entity, originalMap.get(colName));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
}
