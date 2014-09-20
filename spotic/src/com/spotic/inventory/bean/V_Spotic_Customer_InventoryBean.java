package com.spotic.inventory.bean;

public class V_Spotic_Customer_InventoryBean {

	private String inventory_id; 		// 采购ID
	private String fk_customer_id; 		// 客户ID[含有本公司库存、客户、供应商、市场]
	private String customer_name;		//客户姓名
	private String inventory_part_no; 	// 物料编号
	private String inventory_mfg; 		// 物料产地
	private String inventory_dc; 		// 物料年份
	private String inventory_cost; 		// 成本价
	private String inventory_loc; 		// 产地
	private String inventory_lt; 		// LT			
	private String inventory_type; 		// 需求类型[1本公司库存、2客户、3供应商、4市场]
	private String inventory_date; 		// 日期
	private String inventory_allto_state;//任务分配状态[0已分配,1未分配]
	private String inventory_state; 	// 状态[11、准备销售 12、开始销售 13、销售完成 14
										// 销售异常；31、准备供货 32、开始供货 33、供货完成 34、供货异常；
										// 41、准备上货 42、开始上货 43、上货完成 44、上货异常]
	private String inventory_remarks; 	// 备注
	
	
	public String getInventory_allto_state() {
		return inventory_allto_state;
	}
	public void setInventory_allto_state(String inventoryAlltoState) {
		inventory_allto_state = inventoryAlltoState;
	}
	public String getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(String inventoryId) {
		inventory_id = inventoryId;
	}
	public String getFk_customer_id() {
		return fk_customer_id;
	}
	public void setFk_customer_id(String fkCustomerId) {
		fk_customer_id = fkCustomerId;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customerName) {
		customer_name = customerName;
	}
	public String getInventory_part_no() {
		return inventory_part_no;
	}
	public void setInventory_part_no(String inventoryPartNo) {
		inventory_part_no = inventoryPartNo;
	}
	public String getInventory_mfg() {
		return inventory_mfg;
	}
	public void setInventory_mfg(String inventoryMfg) {
		inventory_mfg = inventoryMfg;
	}
	public String getInventory_dc() {
		return inventory_dc;
	}
	public void setInventory_dc(String inventoryDc) {
		inventory_dc = inventoryDc;
	}
	public String getInventory_cost() {
		return inventory_cost;
	}
	public void setInventory_cost(String inventoryCost) {
		inventory_cost = inventoryCost;
	}
	public String getInventory_loc() {
		return inventory_loc;
	}
	public void setInventory_loc(String inventoryLoc) {
		inventory_loc = inventoryLoc;
	}
	public String getInventory_lt() {
		return inventory_lt;
	}
	public void setInventory_lt(String inventoryLt) {
		inventory_lt = inventoryLt;
	}
	public String getInventory_type() {
		return inventory_type;
	}
	public void setInventory_type(String inventoryType) {
		inventory_type = inventoryType;
	}
	public String getInventory_date() {
		return inventory_date;
	}
	public void setInventory_date(String inventoryDate) {
		inventory_date = inventoryDate;
	}
	public String getInventory_state() {
		return inventory_state;
	}
	public void setInventory_state(String inventoryState) {
		inventory_state = inventoryState;
	}
	public String getInventory_remarks() {
		return inventory_remarks;
	}
	public void setInventory_remarks(String inventoryRemarks) {
		inventory_remarks = inventoryRemarks;
	}
	
}


