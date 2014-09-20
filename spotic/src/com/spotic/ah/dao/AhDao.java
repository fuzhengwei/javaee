package com.spotic.ah.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;
import com.stack.util.date.DateUtil;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class AhDao extends HandleBase implements IReflctQueryDao{

	private static IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.ah.bean.V_AhBean");
	
	public boolean doDeleteModelById(String modelId) {
		return false;
	}

	public boolean doInsertModel(Object objBean) {
		return false;
	}

	public ArrayList<?> doSelectModelAllList() {
		return null;
	}

	public Object doSelectModelById(String modelId) {
		return null;
	}

	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		return null;
	}

	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		return rqd.doSelectModelListBySerach(pageBean, objBean);
	}

	public boolean doUpdateModel(Object objBean) {
		return false;
	}
	
	public boolean doUpdateModelById(String ei_id,String ei_state){
		boolean bool = false;
		String sql = "";
		
		if("2".equals(ei_state)){
			sql = "update spotic_emp_inventory set ei_date_2 = ?,ei_state = ? where ei_id = ?";
		}else if("3".equals(ei_state)){
			sql = "update spotic_emp_inventory set ei_date_3 = ?,ei_state = ? where ei_id = ?";
		}
		ps = super.getPs(sql);
		
		try {
			ps.setString(1, DateUtil.getNow());
			ps.setString(2, ei_state);
			ps.setString(3, ei_id);
			bool = ps.executeUpdate() > 0;
			super.commit();
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
		
	}
	
	
	public String doGetEmpCount(){
		ps = super.getPs("select count(emp_id) as empcount from spotic_emp");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("empcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public String doGetCustomerCount(){
		ps = super.getPs("select count(customer_id) as customercount from spotic_customer");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("customercount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public String doGetRfqCount(){
		ps = super.getPs("select count(rfq_id) as rfqcount from spotic_rfq");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("rfqcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}

	public String doGetInventoryUsCount(){
		ps = super.getPs("select count(inventory_id) as iUscount from spotic_inventory where inventory_type = '1'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("iUscount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public String doGetInventoryExcessCount(){
		ps = super.getPs("select count(inventory_id) as iExcesscount from spotic_inventory where inventory_type = '3'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("iExcesscount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public String doGetInventoryOutsideCount(){
		ps = super.getPs("select count(inventory_id) as iOutsidecount from spotic_inventory where inventory_type = '4'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("iOutsidecount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEiNowOne(){
		ps = super.getPs("select count(ei_id) as eicount_1 from spotic_emp_inventory where ei_state = '1' and ei_date_1 like ?");
		try {
			ps.setString(1, "%"+DateUtil.getCurrDate(DateUtil.LONG_DATE_FORMAT)+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEiNow_1(){
		ps = super.getPs("select count(ei_id) as eicount_1 from spotic_emp_inventory where ei_state = '1' and ei_date_1 like ?");
		try {
			ps.setString(1, "%"+DateUtil.getCurrDate(DateUtil.LONG_DATE_FORMAT)+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEiNow_2(){
		ps = super.getPs("select count(ei_id) as eicount_2 from spotic_emp_inventory where ei_state = '2' and ei_date_2 like ?");
		try {
			ps.setString(1, "%"+DateUtil.getCurrDate(DateUtil.LONG_DATE_FORMAT)+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEiNow_3(){
		ps = super.getPs("select count(ei_id) as eicount_3 from spotic_emp_inventory where ei_state = '3' and ei_date_3 like ?");
		try {
			ps.setString(1, "%"+DateUtil.getCurrDate(DateUtil.LONG_DATE_FORMAT)+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_3");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}

	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEiNow_4(){
		ps = super.getPs("select count(ei_id) as eicount_4 from spotic_emp_inventory where ei_state = '4' and ei_date_4 like ?");
		try {
			ps.setString(1, "%"+DateUtil.getCurrDate(DateUtil.LONG_DATE_FORMAT)+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_4");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEi_1(){
		ps = super.getPs("select count(ei_id) as eicount_1 from spotic_emp_inventory where ei_state = '1'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEi_2(){
		ps = super.getPs("select count(ei_id) as eicount_2 from spotic_emp_inventory where ei_state = '2'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEi_3(){
		ps = super.getPs("select count(ei_id) as eicount_3 from spotic_emp_inventory where ei_state = '3'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_3");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	//1、分配完成、2、接受执行、3、提交检查、4、完成关闭
	public String doGetEi_4(){
		ps = super.getPs("select count(ei_id) as eicount_4 from spotic_emp_inventory where ei_state = '4'");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("eicount_4");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public ArrayList<?> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean) {
		return rqd.doSelectModelListBySerachForLike(pageBean, objBean);
	}
}
