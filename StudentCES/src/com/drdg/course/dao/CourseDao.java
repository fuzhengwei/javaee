package com.drdg.course.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.course.bean.CourseBean;
import com.drdg.util.conndb.GetSelectQuery;

public class CourseDao extends GetSelectQuery{

	/**
	 * 新增课程
	 * @param model
	 * @return
	 */
	public boolean doInsertCourse(CourseBean model){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("INSERT INTO [StudentCES].[dbo].[course]([fk_cat_id],[cou_name],[cou_remark]) VALUES(?,?,?)");
			ps.setString(1, model.getFk_cat_id());
			ps.setString(2, model.getCou_name());
			ps.setString(3, model.getCou_remark());
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
	 * 删除课程根据id
	 * @param cou_id
	 * @return
	 */
	public boolean doDeleteCourse(String cou_id){
		boolean bool = false;
		try {
			ps = super.getPs("DELETE FROM [StudentCES].[dbo].[course] WHERE [cou_id] = ?");
			ps.setString(1, cou_id);
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
	 * 修改课程信息
	 * @param model
	 * @return
	 */
	public boolean doUpdateCourse(CourseBean model){
		
		boolean bool = false;
		try {
			ps = super.getPs("UPDATE [StudentCES].[dbo].[course] SET [fk_cat_id] = ?,[cou_name] = ?,[cou_remark] = ? WHERE [cou_id] = ?");
			ps.setString(1, model.getFk_cat_id());
			ps.setString(2, model.getCou_name());
			ps.setString(3, model.getCou_remark());
			ps.setString(4, model.getCou_id());
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
	 * 根据cou_id查找课程
	 * @param cou_id
	 * @return
	 */
	public CourseBean doSelectCourseById(String cou_id){
		CourseBean model = new CourseBean();
		try {
			ps = super.getPs("select b.cou_id cou_id,b.cou_name cou_name,b.cou_remark cou_remark,a.cat_name cat_name from dbo.category a,dbo.course b where a.cat_id = b.fk_cat_id and b.cou_id = ?");
			ps.setString(1, cou_id);
			rs = ps.executeQuery();
			if(rs.next()){
				model.setCou_id(rs.getString("cou_id"));
				model.setFk_cat_id(rs.getString("cat_name"));
				model.setCou_name(rs.getString("cou_name"));
				model.setCou_remark(rs.getString("cou_remark"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
	/**
	 * 查询课程
	 * @return
	 */
	public ArrayList<CourseBean> doSelectCourse(){
		ArrayList<CourseBean> modelList = new ArrayList<CourseBean>();
		
		try {
			ps = super.getPs("select b.cou_id cou_id,b.cou_name cou_name,b.cou_remark cou_remark,a.cat_name cat_name from dbo.category a,dbo.course b where a.cat_id = b.fk_cat_id");
			rs = ps.executeQuery();
			while(rs.next()){
				CourseBean model = new CourseBean();
				model.setCou_id(rs.getString("cou_id"));
				model.setFk_cat_id(rs.getString("cat_name"));
				model.setCou_name(rs.getString("cou_name"));
				model.setCou_remark(rs.getString("cou_remark"));
				
				modelList.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelList;
		
		
	}
	
}
