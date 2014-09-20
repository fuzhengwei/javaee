package com.drdg.results.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.results.bean.ResultsBean;
import com.drdg.results.bean.SCRsBean;
import com.drdg.util.conndb.GetSelectQuery;

public class ResultsDao extends GetSelectQuery{

	/**
	 * 新增成绩信息
	 * @param model
	 * @return
	 */
	public boolean doInsertResults(ResultsBean model){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("INSERT INTO [StudentCES].[dbo].[results]([fk_cou_id],[fk_stu_id],[res_fraction],[res_entrydate],[res_state],[res_remark]) VALUES(?,?,?,?,?,?)");
			ps.setString(1, model.getFk_cou_id());
			ps.setString(2, model.getFk_stu_id());
			ps.setString(3,model.getRes_fraction());
			ps.setString(4, model.getRes_entrydate());
			ps.setString(5, model.getRes_state());
			ps.setString(6, model.getRes_remark());
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
	 * 根据id删除分数
	 * @param res_id
	 * @return
	 */
	public boolean doDeleteResults(String res_id){
		
		boolean bool = false;
		
		try {
			ps = super.getPs("DELETE FROM [StudentCES].[dbo].[results] WHERE [res_id] = ?");
			ps.setString(1, res_id);
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
	
	public boolean doUpdateResults(ResultsBean model){
		boolean bool = false;
		try {
			ps = super.getPs("UPDATE [StudentCES].[dbo].[results] SET [fk_cou_id] = ?,[fk_stu_id] = ?,[res_fraction] = ?,[res_entrydate] = ?,[res_state] = ?,[res_remark] = ? WHERE [res_id] = ?");
			ps.setString(1, model.getFk_cou_id());
			ps.setString(2, model.getFk_stu_id());
			ps.setString(3,model.getRes_fraction());
			ps.setString(4, model.getRes_entrydate());
			ps.setString(5, model.getRes_state());
			ps.setString(6, model.getRes_remark());
			ps.setString(7, model.getRes_id());
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
	
	public SCRsBean doSelectResultsById(String res_id){
		SCRsBean scrModel = new SCRsBean();
		try {
			ps = super.getPs("select a.res_id res_id,b.cou_name cou_name,c.stu_name stu_name,a.res_fraction,a.res_entrydate,a.res_state,a.res_remark,d.cat_name cat_name from dbo.results a,dbo.course b,dbo.student c,dbo.category d where a.fk_cou_id = b.cou_id and a.fk_stu_id = c.stu_id and b.fk_cat_id = d.cat_id and a.res_id = ?");
			ps.setString(1, res_id);
			rs = ps.executeQuery();
			if(rs.next()){
				
				scrModel.setRes_id(rs.getString("res_id"));
				scrModel.setCou_name(rs.getString("cou_name"));
				scrModel.setStu_name(rs.getString("stu_name"));
				scrModel.setRes_fraction(rs.getString("res_fraction"));
				scrModel.setRes_entrydate(rs.getString("res_entrydate"));
				scrModel.setRes_state(rs.getString("res_state"));
				scrModel.setRes_remark(rs.getString("res_remark"));
				scrModel.setCat_name(rs.getString("cat_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scrModel;
	}
	
	/**
	 * 获取学生成绩信息
	 * @return
	 */
	public ArrayList<SCRsBean> doSelectResults(){
		
		ArrayList<SCRsBean> modelList = new ArrayList<SCRsBean>();
		
		
		try {
			ps = super.getPs("select a.res_id res_id,b.cou_name cou_name,c.stu_name stu_name,a.res_fraction,a.res_entrydate,a.res_state,a.res_remark,d.cat_name cat_name from dbo.results a,dbo.course b,dbo.student c,dbo.category d where a.fk_cou_id = b.cou_id and a.fk_stu_id = c.stu_id and b.fk_cat_id = d.cat_id");
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				SCRsBean scrModel = new SCRsBean();
				scrModel.setRes_id(rs.getString("res_id"));
				scrModel.setCou_name(rs.getString("cou_name"));
				scrModel.setStu_name(rs.getString("stu_name"));
				scrModel.setRes_fraction(rs.getString("res_fraction"));
				scrModel.setRes_entrydate(rs.getString("res_entrydate"));
				scrModel.setRes_state(rs.getString("res_state"));
				scrModel.setRes_remark(rs.getString("res_remark"));
				scrModel.setCat_name(rs.getString("cat_name"));
				
				modelList.add(scrModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
	}
	
}
