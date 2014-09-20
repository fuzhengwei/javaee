package com.spotic.ei.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.runner.Request;

import com.spotic.ei.bean.Spotic_Emp_InventoryBean;
import com.spotic.ei.bean.V_EIBean;
import com.spotic.emp.bean.Spotic_EmpBean;
import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class Spotic_Emp_InventoryDao extends HandleBase implements IReflctQueryDao{

	private static IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.ei.bean.Spotic_Emp_InventoryBean");
	private static IReflctQueryDao dao = new ReflectQueryDao("com.spotic.ei.bean.V_EIBean");
	/**
	 * 查询出采购人员
	 * @return
	 */
	public ArrayList<Spotic_EmpBean> doGetPurchaseEmpList(){
		ArrayList<Spotic_EmpBean> empList = new ArrayList<Spotic_EmpBean>();
		ps = super.getPs("SELECT emp_id,emp_name from spotic_emp where emp_power != 1 and emp_state = 0");
		try {
			rs = ps.executeQuery();
			while(rs.next()){
				Spotic_EmpBean empBean = new Spotic_EmpBean();
				empBean.setEmp_id(rs.getString("emp_id"));
				empBean.setEmp_name(rs.getString("emp_name"));
				empList.add(empBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public boolean doDeleteModelById(String modelId) {
		return rqd.doDeleteModelById(modelId);
	}

	public boolean doInsertModel(Object objBean) {
		return rqd.doInsertModel(objBean);
	}

	public ArrayList<?> doSelectModelAllList() {
		return null;
	}

	public Object doSelectModelById(String modelId) {
		return null;
	}

	public ArrayList<?> doSelectEIList(PageBean pageBean){
		
//		ArrayList<V_EIBean> eiList = new ArrayList<V_EIBean>();
//		
//		ps = super.getPs("select a.emp_id as emp_id,a.emp_name as emp_name,b.inventory_type as inventory_type,b.inventory_id as inventory_id,b.inventory_part_no as inventory_part_no,c.ei_id as ei_id,c.ei_date_1 as ei_date_1,c.ei_date_2 as ei_date_2,c.ei_date_3 as ei_date_3,c.ei_date_4 as ei_date_4,c.ei_state as ei_state,c.ei_remarks as ei_remarks  from spotic_emp a,spotic_inventory b,spotic_emp_inventory c where a.emp_id = c.fk_emp_id and b.inventory_id = c.fk_inventory_id limit ?,?");
//		try {
//			ps.setInt(1, pageBean.getFirstResult());
//			ps.setInt(2, pageBean.getMaxResult());
//			rs = ps.executeQuery();
//			
//			while(rs.next()){
//				V_EIBean ei = new V_EIBean();
//				ei.setEi_id(rs.getString("ei_id"));
//				ei.setEmp_id(rs.getString("emp_id"));
//				ei.setEmp_name(rs.getString("emp_name"));
//				ei.setInventory_id(rs.getString("inventory_id"));
//				ei.setInventory_type(rs.getString("inventory_type"));
//				ei.setInventory_part_no(rs.getString("inventory_part_no"));
//				ei.setEi_date_1(rs.getString("ei_date_1"));
//				ei.setEi_date_2(rs.getString("ei_date_2"));
//				ei.setEi_date_3(rs.getString("ei_date_3"));
//				ei.setEi_date_4(rs.getString("ei_date_4"));
//				ei.setEi_state(rs.getString("ei_state"));
//				ei.setEi_remarks(rs.getString("ei_remarks"));
//				
//				eiList.add(ei);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return dao.doSelectModelList(pageBean);
	}
	
	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		return null;
	}

	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		return null;
	}

	public boolean doUpdateModel(Object objBean) {
		return false;
	}
	
	public boolean doUpdate(Spotic_Emp_InventoryBean eiBean){
	
		boolean bool = false;
		
		ps = super.getPs("update spotic_emp_inventory set ei_date_1 = ?,ei_date_2 = ?,ei_date_3 = ?,ei_date_4 = ?,ei_state = ?,ei_remarks = ? where ei_id = ?");
		try {
			ps.setString(1, eiBean.getEi_date_1());
			ps.setString(2, eiBean.getEi_date_2());
			ps.setString(3, eiBean.getEi_date_3());
			ps.setString(4, eiBean.getEi_date_4());
			ps.setString(5, eiBean.getEi_state());
			ps.setString(6, eiBean.getEi_remarks());
			ps.setString(7, eiBean.getEi_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}
	
	public boolean doUpdate_1(Spotic_Emp_InventoryBean eiBean){
		
		boolean bool = false;
		
		ps = super.getPs("update spotic_emp_inventory set ei_date_1 = ?,ei_state = ?,ei_remarks = ? where ei_id = ?");
		try {
			ps.setString(1, eiBean.getEi_date_1());
			ps.setString(2, eiBean.getEi_state());
			ps.setString(3, eiBean.getEi_remarks());
			ps.setString(4, eiBean.getEi_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}
	
	public boolean doUpdate_2(Spotic_Emp_InventoryBean eiBean){
		
		boolean bool = false;
		
		ps = super.getPs("update spotic_emp_inventory set ei_date_2 = ?,ei_state = ?,ei_remarks = ? where ei_id = ?");
		try {
			ps.setString(1, eiBean.getEi_date_2());
			ps.setString(2, eiBean.getEi_state());
			ps.setString(3, eiBean.getEi_remarks());
			ps.setString(4, eiBean.getEi_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}
	
	public boolean doUpdate_3(Spotic_Emp_InventoryBean eiBean){
		
		boolean bool = false;
		
		ps = super.getPs("update spotic_emp_inventory set ei_date_3 = ?,ei_state = ?,ei_remarks = ? where ei_id = ?");
		try {
			ps.setString(1, eiBean.getEi_date_3());
			ps.setString(2, eiBean.getEi_state());
			ps.setString(3, eiBean.getEi_remarks());
			ps.setString(4, eiBean.getEi_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}
	
	public boolean doUpdate_4(Spotic_Emp_InventoryBean eiBean){
		
		boolean bool = false;
		
		ps = super.getPs("update spotic_emp_inventory set ei_date_4 = ?,ei_state = ?,ei_remarks = ? where ei_id = ?");
		try {
			ps.setString(1, eiBean.getEi_date_4());
			ps.setString(2, eiBean.getEi_state());
			ps.setString(3, eiBean.getEi_remarks());
			ps.setString(4, eiBean.getEi_id());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	public boolean doUpdateInventory(String inventory_allto_state,String inventory_id){
		boolean bool = false;
		ps = super.getPs("update spotic_inventory set inventory_allto_state = ? where inventory_id = ?");
		try {
			ps.setString(1, inventory_allto_state);
			ps.setString(2, inventory_id);
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return  bool;
	}

	public ArrayList<?> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean) {
		return dao.doSelectModelListBySerachForLike(pageBean, objBean);
	}
}
