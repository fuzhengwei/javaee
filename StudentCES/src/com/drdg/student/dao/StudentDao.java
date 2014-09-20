package com.drdg.student.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.login.bean.LoginBean;
import com.drdg.student.bean.StudentBean;
import com.drdg.util.conndb.GetSelectQuery;

public class StudentDao extends GetSelectQuery{

	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	public boolean doUpdateStudent(StudentBean stu){
		boolean bool = false;
		try {
			ps = super.getPs("UPDATE [StudentCES].[dbo].[student] SET [stu_name] = ?,[stu_sex] = ?,[stu_birthday] = ?,[stu_nation] = ?,[stu_pa] = ?,[stu_pro_number] = ?,[stu_class_number] = ?,[stu_bedroom_number] = ?,[stu_contact] = ?,[stu_pwd] = ? WHERE [stu_id] = ?");
			ps.setString(1, stu.getStu_name());
			ps.setString(2, stu.getStu_sex());
			ps.setString(3, stu.getStu_birthday());
			ps.setString(4, stu.getStu_nation());
			ps.setString(5, stu.getStu_pa());
			ps.setString(6, stu.getStu_pro_number());
			ps.setString(7, stu.getStu_class_number());
			ps.setString(8, stu.getStu_bedroom_number());
			ps.setString(9, stu.getStu_contact());
			ps.setString(10, stu.getStu_pwd());
			ps.setString(11, stu.getStu_id());
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
	 * 根据stu_id删除学生
	 * @param stu_id
	 * @return
	 */
	public boolean doDeleteStudent(String stu_id){
		boolean bool = false;
		try {
			ps = super.getPs("DELETE FROM [StudentCES].[dbo].[student] WHERE [stu_id] = ?");
			ps.setString(1, stu_id);
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
	 * 学生验证登录
	 * @param model
	 * @return
	 */
	public LoginBean doLoginStudent(LoginBean model){
		
		LoginBean login = new LoginBean();
		
		try {
			ps = super.getPs("SELECT [stu_name],[stu_pwd] FROM [StudentCES].[dbo].[student] WHERE [stu_name] = ? and [stu_pwd] = ?");
			ps.setString(1, model.getName());
			ps.setString(2, model.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				login.setName(rs.getString("stu_name"));
				login.setPassword(rs.getString("stu_pwd"));
				login.setJur("0");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	/**
	 * 查询学生信息
	 * @return
	 */
	public ArrayList<StudentBean> doSelectStudent(){
		ArrayList<StudentBean> modelList = new ArrayList<StudentBean>();
		
		try {
			ps = super.getPs("SELECT [stu_id],[stu_name],[stu_sex],[stu_birthday],[stu_nation],[stu_pa],[stu_pro_number],[stu_class_number],[stu_bedroom_number],[stu_contact] FROM [StudentCES].[dbo].[student]");
			rs = ps.executeQuery();
			
			while(rs.next()){
				StudentBean model = new StudentBean();
				
				model.setStu_id(rs.getString("stu_id"));
				model.setStu_name(rs.getString("stu_name"));
				model.setStu_sex(rs.getString("stu_sex"));
				model.setStu_birthday(rs.getString("stu_birthday"));
				model.setStu_nation(rs.getString("stu_nation"));
				model.setStu_pa(rs.getString("stu_pa"));
				model.setStu_pro_number(rs.getString("stu_pro_number"));
				model.setStu_class_number(rs.getString("stu_class_number"));
				model.setStu_bedroom_number(rs.getString("stu_bedroom_number"));
				model.setStu_contact(rs.getString("stu_contact"));
				
				modelList.add(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
	}
	
	public StudentBean doSelectStudentById(String stu_id){
		StudentBean model = new StudentBean();
		
		try {
			ps = super.getPs("SELECT [stu_id],[stu_name],[stu_pwd],[stu_sex],[stu_birthday],[stu_nation],[stu_pa],[stu_pro_number],[stu_class_number],[stu_bedroom_number],[stu_contact] FROM [StudentCES].[dbo].[student] WHERE [stu_id] = ?");
			ps.setString(1, stu_id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				model.setStu_id(rs.getString("stu_id"));
				model.setStu_name(rs.getString("stu_name"));
				model.setStu_pwd(rs.getString("stu_pwd"));
				model.setStu_sex(rs.getString("stu_sex"));
				model.setStu_birthday(rs.getString("stu_birthday"));
				model.setStu_nation(rs.getString("stu_nation"));
				model.setStu_pa(rs.getString("stu_pa"));
				model.setStu_pro_number(rs.getString("stu_pro_number"));
				model.setStu_class_number(rs.getString("stu_class_number"));
				model.setStu_bedroom_number(rs.getString("stu_bedroom_number"));
				model.setStu_contact(rs.getString("stu_contact"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	/**
	 * 新增学生信息
	 * @param stu
	 * @return
	 */
	public boolean doInsertStudent(StudentBean stu){
		boolean bool = false;
		try {
			ps = super.getPs("INSERT INTO [StudentCES].[dbo].[student]([stu_name],[stu_sex],[stu_birthday],[stu_nation],[stu_pa],[stu_pro_number],[stu_class_number],[stu_bedroom_number],[stu_contact],[stu_pwd])  VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, stu.getStu_name());
			ps.setString(2, stu.getStu_sex());
			ps.setString(3, stu.getStu_birthday());
			ps.setString(4, stu.getStu_nation());
			ps.setString(5, stu.getStu_pa());
			ps.setString(6, stu.getStu_pro_number());
			ps.setString(7, stu.getStu_class_number());
			ps.setString(8, stu.getStu_bedroom_number());
			ps.setString(9, stu.getStu_contact());
			ps.setString(10, stu.getStu_pwd());
			
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
	
}
