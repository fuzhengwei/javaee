package com.drdg.category.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.category.bean.CategoryBean;
import com.drdg.util.conndb.GetSelectQuery;

public class CategoryDao extends GetSelectQuery{

	/**
	 * ����cat_id��ѯ���
	 * @param cat_id
	 * @return
	 */
	public CategoryBean doSelectCategoryById(String cat_id){
		
		CategoryBean model = new CategoryBean();
		
		try {
			ps = super.getPs("SELECT [cat_id],[cat_name],[cat_weight],[cat_remark] FROM [StudentCES].[dbo].[category] WHERE [cat_id] = ?");
			ps.setString(1, cat_id);
			rs = ps.executeQuery();
			if(rs.next()){
				model.setCat_id(rs.getString("cat_id"));
				model.setCat_name(rs.getString("cat_name"));
				model.setCat_weight(rs.getString("cat_weight"));
				model.setCat_remark(rs.getString("cat_remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * ��ÿγ� �����б�
	 * @return
	 */
	public ArrayList<CategoryBean> doSelectCategory(){
		
		ArrayList<CategoryBean> modelList = new ArrayList<CategoryBean>();
		
		try {
			ps = super.getPs("SELECT [cat_id],[cat_name],[cat_weight],[cat_remark] FROM [StudentCES].[dbo].[category]");
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				CategoryBean model = new CategoryBean();
				
				model.setCat_id(rs.getString("cat_id"));
				model.setCat_name(rs.getString("cat_name"));
				model.setCat_weight(rs.getString("cat_weight"));
				model.setCat_remark(rs.getString("cat_remark"));
				
				modelList.add(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
	}
	
	/**
	 * ����γ����
	 * @param model
	 * @return
	 */
	public boolean doInsertCategory(CategoryBean model){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("INSERT INTO [StudentCES].[dbo].[category]([cat_name],[cat_weight],[cat_remark]) VALUES(?,?,?)");
			ps.setString(1, model.getCat_name());
			ps.setString(2, model.getCat_weight());
			ps.setString(3, model.getCat_remark());
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
	 * ���������Ϣ
	 * @param model
	 * @return
	 */
	public boolean doUpdateCategory(CategoryBean model){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("UPDATE [StudentCES].[dbo].[category] SET [cat_name] = ?,[cat_weight] = ?,[cat_remark] = ? WHERE [cat_id] = ?");
			ps.setString(1, model.getCat_name());
			ps.setString(2, model.getCat_weight());
			ps.setString(3, model.getCat_remark());
			ps.setString(4, model.getCat_id());
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
	 * ����idɾ�����
	 * @param cat_id
	 * @return
	 */
	public boolean doDeleteCategoy(String cat_id){
		boolean bool = false;
		try {
			ps = super.getPs("DELETE FROM [StudentCES].[dbo].[category] WHERE [cat_id] = ?");
			ps.setString(1, cat_id);
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
