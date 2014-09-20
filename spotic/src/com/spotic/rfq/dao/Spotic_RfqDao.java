package com.spotic.rfq.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.spotic.customer.bean.Spotic_CustomerBean;
import com.spotic.emp.bean.Spotic_EmpBean;
import com.spotic.rfq.bean.V_Spotic_RfqBean;
import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;
import com.stack.util.rsq.IReflctQueryDao;

public class Spotic_RfqDao extends HandleBase implements IReflctQueryDao{

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
	
	/**
	 * 查询客户
	 * @return
	 */
	public ArrayList<Spotic_CustomerBean> doGetTwoTypeCustomer(){
		ArrayList<Spotic_CustomerBean> customerList = new ArrayList<Spotic_CustomerBean>();
		ps = super.getPs("SELECT customer_id,customer_company,customer_name FROM spotic_customer where customer_type = 2");
		try {
			rs = ps.executeQuery();
			while(rs.next()){
				Spotic_CustomerBean customerBean = new Spotic_CustomerBean();
				customerBean.setCustomer_id(rs.getString("customer_id"));
				customerBean.setCustomer_name(rs.getString("customer_name"));
				customerBean.setCustomer_company(rs.getString("customer_company"));
				customerList.add(customerBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public ArrayList<V_Spotic_RfqBean> doSelectModelListByMoreTableBySerachForLike(PageBean pageBean,String rfq_part_no){
		ArrayList<V_Spotic_RfqBean> modelList = new ArrayList<V_Spotic_RfqBean>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("r.rfq_id rfq_id,");
		sql.append("r.fk_sp_emp_id fk_sp_emp_id,");
		sql.append("a.emp_name fk_sp_emp_name,");
		sql.append("r.fk_ppa_emp_id fk_ppa_emp_id,");
		sql.append("b.emp_name fk_ppa_emp_name,");
		sql.append("r.fk_apa_emp_id fk_apa_emp_id,");
		sql.append("c.emp_name fk_apa_emp_name,");
		sql.append("r.fk_customer_id fk_customer_id,");
		sql.append("s.customer_company fk_customer_company,");
		sql.append("s.customer_name fk_customer_name,");
		sql.append("r.rfq_part_no rfq_part_no,");
		sql.append("r.rfq_cust_part_no rfq_cust_part_no,");
		sql.append("r.rfq_mfg rfq_mfg,");
		sql.append("r.rfq_dc rfq_dc,");
		sql.append("r.rfq_alternative rfq_alternative,");
		sql.append("r.rfq_quantity rfq_quantity,");
		sql.append("r.rfq_packaging rfq_packaging,");
		sql.append("r.rfq_target_price rfq_target_price,");
		sql.append("r.rfq_resale rfq_resale,");
		sql.append("r.rfq_cost rfq_cost,");
		sql.append("r.rfq_internal rfq_internal,");
		sql.append("r.rfq_routing_history rfq_routing_history,");
		sql.append("r.rfq_loc rfq_loc,");
		sql.append("r.rfq_date rfq_date,");
		sql.append("r.rfq_dock_date rfq_dock_date,");
		sql.append("r.rfq_state rfq_state ");
		sql.append("FROM ");
		sql.append("spotic_rfq r ");
		sql.append("Inner Join spotic_emp a ON r.fk_sp_emp_id = a.emp_id ");
		sql.append("Inner Join spotic_emp b ON r.fk_ppa_emp_id = b.emp_id ");
		sql.append("Inner Join spotic_emp c ON r.fk_apa_emp_id = c.emp_id ");
		sql.append("Inner Join spotic_customer s ON r.fk_customer_id = s.customer_id ");
		sql.append("where rfq_part_no like ? ");
		sql.append("limit ?,?");
		
		try {
			ps = super.getPs(sql.toString());
			ps.setString(1, "%"+rfq_part_no+"%");
			ps.setInt(2,pageBean.getFirstResult());
			ps.setInt(3, pageBean.getMaxResult());
			rs = ps.executeQuery();
			while(rs.next()){
				V_Spotic_RfqBean rfq = new V_Spotic_RfqBean();
				rfq.setFk_apa_emp_id(rs.getString("fk_apa_emp_id"));
				rfq.setFk_apa_emp_name(rs.getString("fk_apa_emp_name"));
				rfq.setFk_customer_company(rs.getString("fk_customer_company"));
				rfq.setFk_customer_id(rs.getString("fk_customer_id"));
				rfq.setFk_customer_name(rs.getString("fk_customer_name"));
				rfq.setFk_sp_emp_id(rs.getString("fk_sp_emp_id"));
				rfq.setFk_sp_emp_name(rs.getString("fk_sp_emp_name"));
				rfq.setRfq_alternative(rs.getString("rfq_alternative"));
				rfq.setRfq_cost(rs.getString("rfq_cost"));
				rfq.setRfq_cust_part_no(rs.getString("rfq_cust_part_no"));
				rfq.setRfq_date(rs.getString("rfq_date"));
				rfq.setRfq_dc(rs.getString("rfq_dc"));
				rfq.setRfq_dock_date(rs.getString("rfq_dock_date"));
				rfq.setRfq_id(rs.getString("rfq_id"));
				rfq.setRfq_internal(rs.getString("rfq_internal"));
				rfq.setRfq_loc(rs.getString("rfq_loc"));
				rfq.setRfq_mfg(rs.getString("rfq_mfg"));
				rfq.setRfq_packaging(rs.getString("rfq_packaging"));
				rfq.setRfq_part_no(rs.getString("rfq_part_no"));
				rfq.setRfq_quantity(rs.getString("rfq_quantity"));
				rfq.setRfq_resale(rs.getString("rfq_resale"));
				rfq.setRfq_routing_history(rs.getString("rfq_routing_history"));
				rfq.setRfq_state(rs.getString("rfq_state"));
				rfq.setRfq_target_price(rs.getString("rfq_target_price"));
				
				modelList.add(rfq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	
	
	public String doSelectCount(){
		String pagecount = "0";
		ps = super.getPs("select count(rfq_id) pagecount from spotic_rfq");
		try {
			rs = ps.executeQuery();
			if(rs.next()){
				pagecount = rs.getString("pagecount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagecount;
	}
	
	public boolean doDeleteModelById(String modelId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doInsertModel(Object objBean) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<?> doSelectModelAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object doSelectModelById(String modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean doUpdateModel(Object objBean) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<V_Spotic_RfqBean> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean) {
		
		ArrayList<V_Spotic_RfqBean> modelList = new ArrayList<V_Spotic_RfqBean>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("r.rfq_id rfq_id,");
		sql.append("r.fk_sp_emp_id fk_sp_emp_id,");
		sql.append("a.emp_name fk_sp_emp_name,");
		sql.append("r.fk_ppa_emp_id fk_ppa_emp_id,");
		sql.append("b.emp_name fk_ppa_emp_name,");
		sql.append("r.fk_apa_emp_id fk_apa_emp_id,");
		sql.append("c.emp_name fk_apa_emp_name,");
		sql.append("r.fk_customer_id fk_customer_id,");
		sql.append("s.customer_company fk_customer_company,");
		sql.append("s.customer_name fk_customer_name,");
		sql.append("r.rfq_part_no rfq_part_no,");
		sql.append("r.rfq_cust_part_no rfq_cust_part_no,");
		sql.append("r.rfq_mfg rfq_mfg,");
		sql.append("r.rfq_dc rfq_dc,");
		sql.append("r.rfq_alternative rfq_alternative,");
		sql.append("r.rfq_quantity rfq_quantity,");
		sql.append("r.rfq_packaging rfq_packaging,");
		sql.append("r.rfq_target_price rfq_target_price,");
		sql.append("r.rfq_resale rfq_resale,");
		sql.append("r.rfq_cost rfq_cost,");
		sql.append("r.rfq_internal rfq_internal,");
		sql.append("r.rfq_routing_history rfq_routing_history,");
		sql.append("r.rfq_loc rfq_loc,");
		sql.append("r.rfq_date rfq_date,");
		sql.append("r.rfq_dock_date rfq_dock_date,");
		sql.append("r.rfq_state rfq_state ");
		sql.append("FROM ");
		sql.append("spotic_rfq r ");
		sql.append("Inner Join spotic_emp a ON r.fk_sp_emp_id = a.emp_id ");
		sql.append("Inner Join spotic_emp b ON r.fk_ppa_emp_id = b.emp_id ");
		sql.append("Inner Join spotic_emp c ON r.fk_apa_emp_id = c.emp_id ");
		sql.append("Inner Join spotic_customer s ON r.fk_customer_id = s.customer_id ");
//		sql.append("where rfq_part_no like ?");
		sql.append(" limit ?,?");
		System.out.println(sql.toString());
		try {
			ps = super.getPs(sql.toString());
//			ps.setString(1, "%'"+objBean.toString()+"'%");
			ps.setInt(1, pageBean.getFirstResult());
			ps.setInt(2, pageBean.getMaxResult());
			while(rs.next()){
				V_Spotic_RfqBean rfq = new V_Spotic_RfqBean();
				rfq.setFk_apa_emp_id(rs.getString("fk_apa_emp_id"));
				rfq.setFk_apa_emp_name(rs.getString("fk_apa_emp_name"));
				rfq.setFk_customer_company(rs.getString("fk_customer_company"));
				rfq.setFk_customer_id(rs.getString("fk_customer_id"));
				rfq.setFk_customer_name(rs.getString("fk_customer_name"));
				rfq.setFk_sp_emp_id(rs.getString("fk_sp_emp_id"));
				rfq.setFk_sp_emp_name(rs.getString("fk_sp_emp_name"));
				rfq.setRfq_alternative(rs.getString("rfq_alternative"));
				rfq.setRfq_cost(rs.getString("rfq_cost"));
				rfq.setRfq_cust_part_no(rs.getString("rfq_cust_part_no"));
				rfq.setRfq_date(rs.getString("rfq_date"));
				rfq.setRfq_dc(rs.getString("rfq_dc"));
				rfq.setRfq_dock_date(rs.getString("rfq_dock_date"));
				rfq.setRfq_id(rs.getString("rfq_id"));
				rfq.setRfq_internal(rs.getString("rfq_internal"));
				rfq.setRfq_loc(rs.getString("rfq_loc"));
				rfq.setRfq_mfg(rs.getString("rfq_mfg"));
				rfq.setRfq_packaging(rs.getString("rfq_packaging"));
				rfq.setRfq_part_no(rs.getString("rfq_part_no"));
				rfq.setRfq_quantity(rs.getString("rfq_quantity"));
				rfq.setRfq_resale(rs.getString("rfq_resale"));
				rfq.setRfq_routing_history(rs.getString("rfq_routing_history"));
				rfq.setRfq_state(rs.getString("rfq_state"));
				rfq.setRfq_target_price(rs.getString("rfq_target_price"));
				
				modelList.add(rfq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
	}

	public Object doSelectModelListByMoreTable(PageBean pageBean) {
		ArrayList<V_Spotic_RfqBean> modelList = new ArrayList<V_Spotic_RfqBean>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("r.rfq_id rfq_id,");
		sql.append("r.fk_sp_emp_id fk_sp_emp_id,");
		sql.append("a.emp_name fk_sp_emp_name,");
		sql.append("r.fk_ppa_emp_id fk_ppa_emp_id,");
		sql.append("b.emp_name fk_ppa_emp_name,");
		sql.append("r.fk_apa_emp_id fk_apa_emp_id,");
		sql.append("c.emp_name fk_apa_emp_name,");
		sql.append("r.fk_customer_id fk_customer_id,");
		sql.append("s.customer_company fk_customer_company,");
		sql.append("s.customer_name fk_customer_name,");
		sql.append("r.rfq_part_no rfq_part_no,");
		sql.append("r.rfq_cust_part_no rfq_cust_part_no,");
		sql.append("r.rfq_mfg rfq_mfg,");
		sql.append("r.rfq_dc rfq_dc,");
		sql.append("r.rfq_alternative rfq_alternative,");
		sql.append("r.rfq_quantity rfq_quantity,");
		sql.append("r.rfq_packaging rfq_packaging,");
		sql.append("r.rfq_target_price rfq_target_price,");
		sql.append("r.rfq_resale rfq_resale,");
		sql.append("r.rfq_cost rfq_cost,");
		sql.append("r.rfq_internal rfq_internal,");
		sql.append("r.rfq_routing_history rfq_routing_history,");
		sql.append("r.rfq_loc rfq_loc,");
		sql.append("r.rfq_date rfq_date,");
		sql.append("r.rfq_dock_date rfq_dock_date,");
		sql.append("r.rfq_state rfq_state ");
		sql.append("FROM ");
		sql.append("spotic_rfq r ");
		sql.append("Inner Join spotic_emp a ON r.fk_sp_emp_id = a.emp_id ");
		sql.append("Inner Join spotic_emp b ON r.fk_ppa_emp_id = b.emp_id ");
		sql.append("Inner Join spotic_emp c ON r.fk_apa_emp_id = c.emp_id ");
		sql.append("Inner Join spotic_customer s ON r.fk_customer_id = s.customer_id ");
		sql.append(" limit ?,?");
		try {
			ps = super.getPs(sql.toString());
			ps.setInt(1, pageBean.getFirstResult());
			ps.setInt(2, pageBean.getMaxResult());
			rs = ps.executeQuery();
			while(rs.next()){
				V_Spotic_RfqBean rfq = new V_Spotic_RfqBean();
				rfq.setFk_apa_emp_id(rs.getString("fk_apa_emp_id"));
				rfq.setFk_apa_emp_name(rs.getString("fk_apa_emp_name"));
				rfq.setFk_customer_company(rs.getString("fk_customer_company"));
				rfq.setFk_customer_id(rs.getString("fk_customer_id"));
				rfq.setFk_customer_name(rs.getString("fk_customer_name"));
				rfq.setFk_sp_emp_id(rs.getString("fk_sp_emp_id"));
				rfq.setFk_sp_emp_name(rs.getString("fk_sp_emp_name"));
				rfq.setRfq_alternative(rs.getString("rfq_alternative"));
				rfq.setRfq_cost(rs.getString("rfq_cost"));
				rfq.setRfq_cust_part_no(rs.getString("rfq_cust_part_no"));
				rfq.setRfq_date(rs.getString("rfq_date"));
				rfq.setRfq_dc(rs.getString("rfq_dc"));
				rfq.setRfq_dock_date(rs.getString("rfq_dock_date"));
				rfq.setRfq_id(rs.getString("rfq_id"));
				rfq.setRfq_internal(rs.getString("rfq_internal"));
				rfq.setRfq_loc(rs.getString("rfq_loc"));
				rfq.setRfq_mfg(rs.getString("rfq_mfg"));
				rfq.setRfq_packaging(rs.getString("rfq_packaging"));
				rfq.setRfq_part_no(rs.getString("rfq_part_no"));
				rfq.setRfq_quantity(rs.getString("rfq_quantity"));
				rfq.setRfq_resale(rs.getString("rfq_resale"));
				rfq.setRfq_routing_history(rs.getString("rfq_routing_history"));
				rfq.setRfq_state(rs.getString("rfq_state"));
				rfq.setRfq_target_price(rs.getString("rfq_target_price"));
				
				modelList.add(rfq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelList;
	}
	
}
