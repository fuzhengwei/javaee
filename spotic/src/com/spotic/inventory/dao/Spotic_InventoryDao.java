package com.spotic.inventory.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.spotic.customer.bean.Spotic_CustomerBean;
import com.spotic.inventory.bean.V_Spotic_Customer_InventoryBean;
import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class Spotic_InventoryDao extends HandleBase implements IReflctQueryDao{

	private static IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.inventory.bean.Spotic_InventoryBean");
	private static IReflctQueryDao dao = new ReflectQueryDao("com.spotic.inventory.bean.V_Spotic_Customer_InventoryBean");
	/**
	 * 
	 * @param type
	 * @return
	 */
	public ArrayList<Spotic_CustomerBean> doSelectModelByType(String type){
		ArrayList<Spotic_CustomerBean> customerList = new ArrayList<Spotic_CustomerBean>();
		ps = super.getPs("select customer_id,customer_name from spotic_customer where customer_type = ?");
		try {
			ps.setString(1, type);
			rs = ps.executeQuery();
			while(rs.next()){
				Spotic_CustomerBean customer = new Spotic_CustomerBean();
				customer.setCustomer_id(rs.getString("customer_id"));
				customer.setCustomer_name(rs.getString("customer_name"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public ArrayList<?> doSelectModelListT1ByType(V_Spotic_Customer_InventoryBean objBean,PageBean pageBean){
		
//		ArrayList<V_Spotic_Customer_InventoryBean> t1List = new ArrayList<V_Spotic_Customer_InventoryBean>();
//		ps = super.getPs("select a.customer_name as customer_name,b.inventory_allto_state as inventory_allto_state,b.inventory_id as inventory_id,b.fk_customer_id as fk_customer_id,b.inventory_cost as inventory_cost,b.inventory_date as inventory_date,b.inventory_dc as inventory_dc,b.inventory_loc as inventory_loc,b.inventory_lt as inventory_lt,b.inventory_mfg as inventory_mfg,b.inventory_part_no as inventory_part_no,b.inventory_remarks as inventory_remarks,b.inventory_state as inventory_state,b.inventory_type as inventory_type from spotic_customer a,spotic_inventory b where a.customer_id = b.fk_customer_id and b.inventory_type = ? LIMIT ?,?");
//		try {
//			ps.setString(1, inventory_type);
//			ps.setInt(2, pageBean.getFirstResult());
//			ps.setInt(3, pageBean.getMaxResult());
//			rs = ps.executeQuery();
//			while(rs.next()){
//				V_Spotic_Customer_InventoryBean ci = new V_Spotic_Customer_InventoryBean();
//				ci.setCustomer_name(rs.getString("customer_name"));
//				ci.setFk_customer_id(rs.getString("fk_customer_id"));
//				ci.setInventory_cost(rs.getString("inventory_cost"));
//				ci.setInventory_date(rs.getString("inventory_date"));
//				ci.setInventory_dc(rs.getString("inventory_dc"));
//				ci.setInventory_id(rs.getString("inventory_id"));
//				ci.setInventory_loc(rs.getString("inventory_loc"));
//				ci.setInventory_lt(rs.getString("inventory_lt"));
//				ci.setInventory_mfg(rs.getString("inventory_mfg"));
//				ci.setInventory_part_no(rs.getString("inventory_part_no"));
//				ci.setInventory_remarks(rs.getString("inventory_remarks"));
//				ci.setInventory_allto_state(rs.getString("inventory_allto_state"));
//				ci.setInventory_state(rs.getString("inventory_state"));
//				ci.setInventory_type(rs.getString("inventory_type"));
//				t1List.add(ci);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return dao.doSelectModelListBySerach(pageBean, objBean);
	}
	
	public boolean doDeleteModelById(String modelId) {
		return rqd.doDeleteModelById(modelId);
	}

	public boolean doInsertModel(Object objBean) {
		return rqd.doInsertModel(objBean);
	}

	public ArrayList<?> doSelectModelAllList() {
		return rqd.doSelectModelAllList();
	}

	public Object doSelectModelById(String modelId) {
		return rqd.doSelectModelById(modelId);
	}

	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		return rqd.doSelectModelList(pageBean);
	}

	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		return rqd.doSelectModelListBySerach(pageBean, objBean);
	}

	public boolean doUpdateModel(Object objBean) {
		return rqd.doUpdateModel(objBean);
	}

	public ArrayList<?> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean) {
		return dao.doSelectModelListBySerachForLike(pageBean, objBean);
	}
	
}
