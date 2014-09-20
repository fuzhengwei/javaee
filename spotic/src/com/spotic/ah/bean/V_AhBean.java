package com.spotic.ah.bean;

public class V_AhBean {

	private String ei_id;				// 自增ID
	private String emp_id;			// 雇员外键
	private String emp_name; 			//雇员姓名
	private String inventory_id; 	// 订单外键
	private String inventory_type;		//需求类型[1本公司库存、2客户、3供应商、4市场]
	private String inventory_part_no;   // 物料编号
	private String inventory_state;		//状态
	private String ei_date_1;			// 1 2 3 4 都是日期
	private String ei_date_2;			//
	private String ei_date_3;			//
	private String ei_date_4;			//
	private String ei_state;			// 1、分配完成、2、接受执行、3、提交检查、4、申请撤销
	private String ei_remarks;			// 备注
	public String getEi_id() {
		return ei_id;
	}
	public void setEi_id(String eiId) {
		ei_id = eiId;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String empId) {
		emp_id = empId;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String empName) {
		emp_name = empName;
	}
	public String getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(String inventoryId) {
		inventory_id = inventoryId;
	}
	public String getInventory_type() {
		return inventory_type;
	}
	public void setInventory_type(String inventoryType) {
		inventory_type = inventoryType;
	}
	public String getInventory_part_no() {
		return inventory_part_no;
	}
	public void setInventory_part_no(String inventoryPartNo) {
		inventory_part_no = inventoryPartNo;
	}
	public String getInventory_state() {
		return inventory_state;
	}
	public void setInventory_state(String inventoryState) {
		inventory_state = inventoryState;
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
