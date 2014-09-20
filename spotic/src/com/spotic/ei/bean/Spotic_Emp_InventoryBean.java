package com.spotic.ei.bean;

public class Spotic_Emp_InventoryBean {

	private String ei_id;// 自增ID
	private String fk_emp_id;// 雇员外键
	private String fk_inventory_id;// 订单外键
	private String ei_date_1;// 1 2 3 4 都是日期
	private String ei_date_2;//
	private String ei_date_3;//
	private String ei_date_4;//
	private String ei_state;// 1、分配完成、2、接受执行、3、提交检查、4、申请撤销
	private String ei_remarks;// 备注
	public String getEi_id() {
		return ei_id;
	}
	public void setEi_id(String eiId) {
		ei_id = eiId;
	}
	public String getFk_emp_id() {
		return fk_emp_id;
	}
	public void setFk_emp_id(String fkEmpId) {
		fk_emp_id = fkEmpId;
	}
	public String getFk_inventory_id() {
		return fk_inventory_id;
	}
	public void setFk_inventory_id(String fkInventoryId) {
		fk_inventory_id = fkInventoryId;
	}
	public String getEi_date_1() {
		return ei_date_1;
	}
	public void setEi_date_1(String eiDate_1) {
		ei_date_1 = eiDate_1;
	}
	public String getEi_date_2() {
		return ei_date_2;
	}
	public void setEi_date_2(String eiDate_2) {
		ei_date_2 = eiDate_2;
	}
	public String getEi_date_3() {
		return ei_date_3;
	}
	public void setEi_date_3(String eiDate_3) {
		ei_date_3 = eiDate_3;
	}
	public String getEi_date_4() {
		return ei_date_4;
	}
	public void setEi_date_4(String eiDate_4) {
		ei_date_4 = eiDate_4;
	}
	public String getEi_state() {
		return ei_state;
	}
	public void setEi_state(String eiState) {
		ei_state = eiState;
	}
	public String getEi_remarks() {
		return ei_remarks;
	}
	public void setEi_remarks(String eiRemarks) {
		ei_remarks = eiRemarks;
	}

}
