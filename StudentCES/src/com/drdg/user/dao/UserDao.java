package com.drdg.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.login.bean.LoginBean;
import com.drdg.user.bean.UserBean;
import com.drdg.util.conndb.GetSelectQuery;

public class UserDao extends GetSelectQuery {

	/**
	 * 更具用户名密码进行验证登录
	 * @param model
	 * @return
	 */
	public LoginBean doLoginUser(LoginBean model){
		LoginBean login = new LoginBean();
		try {
			ps = super.getPs("select [user_name],[user_password],[user_jur] from [StudentCES].[dbo].[users] where [user_name] = ? and [user_password] = ?");
			ps.setString(1, model.getName());
			ps.setString(2, model.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				login.setName(rs.getString("user_name"));
				login.setPassword(rs.getString("user_password"));
				login.setJur(rs.getString("user_jur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	/**
	 * 新增用户
	 * @param model
	 * @return
	 */
	public boolean doInsertUser(UserBean model){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("INSERT INTO [StudentCES].[dbo].[users]([user_name],[user_password],[user_jur],[user_contact]) VALUES(?,?,?,?)");
			ps.setString(1, model.getUser_name());
			ps.setString(2, model.getUser_password());
			ps.setString(3, model.getUser_jur());
			ps.setString(4, model.getUser_contact());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			try {
				super.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bool;
		
	}
	
	/**
	 * 根据id删除用户
	 * @param user_id
	 * @return
	 */
	public boolean doDeleteUser(String user_id){
		boolean bool = false;
		try {
			ps = super.getPs("DELETE FROM [StudentCES].[dbo].[users] WHERE [user_id] = ?");
			ps.setString(1, user_id);
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			try {
				super.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 修改user信息
	 * @param model
	 * @return
	 */
	public boolean doUpdateUser(UserBean model){
		boolean bool = false;
		
		try {
			ps = super.getPs("UPDATE [StudentCES].[dbo].[users] SET [user_name] = ?,[user_password] = ?,[user_jur] = ?,[user_contact] = ? WHERE [user_id] = ?");
			ps.setString(1, model.getUser_name());
			ps.setString(2, model.getUser_password());
			ps.setString(3, model.getUser_jur());
			ps.setString(4, model.getUser_contact());
			ps.setString(5, model.getUser_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			try {
				super.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bool;
		
	}
	
	/**
	 * 根据user_id查询用户信息
	 * @param user_id
	 * @return
	 */
	public UserBean doSelectUserById(String user_id){
		UserBean model = new UserBean();
		try {
			ps = super.getPs("select [user_id],[user_name],[user_password],[user_jur],[user_contact] from [StudentCES].[dbo].[users] where [user_id] = ?");
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()){
				model.setUser_id(rs.getString("user_id"));
				model.setUser_name(rs.getString("user_name"));
				model.setUser_password(rs.getString("user_password"));
				model.setUser_jur(jur2Str(rs.getString("user_jur")));
				model.setUser_contact(rs.getString("user_contact"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 查询用户列表
	 * @return
	 */
	public ArrayList<UserBean> doSelectUser(){
		
		ArrayList<UserBean> modelList = new ArrayList<UserBean>();
		
		try {
			
			ps = super.getPs("select [user_id],[user_name],[user_password],[user_jur],[user_contact] from [StudentCES].[dbo].[users]");
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				UserBean model = new UserBean();
				
				model.setUser_id(rs.getString("user_id"));
				model.setUser_name(rs.getString("user_name"));
				model.setUser_password(rs.getString("user_password"));
				model.setUser_jur(jur2Str(rs.getString("user_jur")));
				model.setUser_contact(rs.getString("user_contact"));
				
				modelList.add(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
		
	}

	/**
	 * 转换
	 * @param userJur
	 * @return
	 */
	private String jur2Str(String userJur){
		if("1".equals(userJur)){
			return "管理员";
		}else if("2".equals(userJur)){
			return "导员";
		}else{
			return "班长";
		}
	}
	
	
}
