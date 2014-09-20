package com.spotic.rfq.bean;

public class Spotic_RfqBean {

	private String rfq_id;				//需求订单ID	
	private String fk_sp_emp_id;		//销售人员外键ID	
	private String fk_ppa_emp_id;		//初选采购人员外键ID	
	private String fk_apa_emp_id;		//备选采购人员外键ID	
	private String fk_customer_id;		//客户ID	
	private String rfq_part_no;			//物料号	
	private String rfq_cust_part_no;	//客户物料号	
	private String rfq_mfg;				//物料产地	
	private String rfq_dc;				//物料年份	
	private String rfq_alternative;		//可替代物料	
	private String rfq_quantity;		//需求数量	
	private String rfq_packaging;		//包装	
	private String rfq_target_price;	//目标价格	
	private String rfq_resale;			//卖价	
	private String rfq_cost;			//成本价	
	private String rfq_internal;		//内部信息说明	
	private String rfq_routing_history;	//历史	
	private String rfq_loc;				//产地
	private String rfq_date;			//日期
	private String rfq_dock_date;		//到货日期
	private String rfq_state;			//[1预备采购、2开始采购、3采购完成、4异常关闭]
	public String getRfq_id() {
		return rfq_id;
	}
	public void setRfq_id(String rfqId) {
		rfq_id = rfqId;
	}
	public String getFk_sp_emp_id() {
		return fk_sp_emp_id;
	}
	public void setFk_sp_emp_id(String fkSpEmpId) {
		fk_sp_emp_id = fkSpEmpId;
	}
	public String getFk_ppa_emp_id() {
		return fk_ppa_emp_id;
	}
	public void setFk_ppa_emp_id(String fkPpaEmpId) {
		fk_ppa_emp_id = fkPpaEmpId;
	}
	public String getFk_apa_emp_id() {
		return fk_apa_emp_id;
	}
	public void setFk_apa_emp_id(String fkApaEmpId) {
		fk_apa_emp_id = fkApaEmpId;
	}
	public String getFk_customer_id() {
		return fk_customer_id;
	}
	public void setFk_customer_id(String fkCustomerId) {
		fk_customer_id = fkCustomerId;
	}
	public String getRfq_part_no() {
		return rfq_part_no;
	}
	public void setRfq_part_no(String rfqPartNo) {
		rfq_part_no = rfqPartNo;
	}
	public String getRfq_cust_part_no() {
		return rfq_cust_part_no;
	}
	public void setRfq_cust_part_no(String rfqCustPartNo) {
		rfq_cust_part_no = rfqCustPartNo;
	}
	public String getRfq_mfg() {
		return rfq_mfg;
	}
	public void setRfq_mfg(String rfqMfg) {
		rfq_mfg = rfqMfg;
	}
	public String getRfq_dc() {
		return rfq_dc;
	}
	public void setRfq_dc(String rfqDc) {
		rfq_dc = rfqDc;
	}
	public String getRfq_alternative() {
		return rfq_alternative;
	}
	public void setRfq_alternative(String rfqAlternative) {
		rfq_alternative = rfqAlternative;
	}
	public String getRfq_quantity() {
		return rfq_quantity;
	}
	public void setRfq_quantity(String rfqQuantity) {
		rfq_quantity = rfqQuantity;
	}
	public String getRfq_packaging() {
		return rfq_packaging;
	}
	public void setRfq_packaging(String rfqPackaging) {
		rfq_packaging = rfqPackaging;
	}
	public String getRfq_target_price() {
		return rfq_target_price;
	}
	public void setRfq_target_price(String rfqTargetPrice) {
		rfq_target_price = rfqTargetPrice;
	}
	public String getRfq_resale() {
		return rfq_resale;
	}
	public void setRfq_resale(String rfqResale) {
		rfq_resale = rfqResale;
	}
	public String getRfq_cost() {
		return rfq_cost;
	}
	public void setRfq_cost(String rfqCost) {
		rfq_cost = rfqCost;
	}
	public String getRfq_internal() {
		return rfq_internal;
	}
	public void setRfq_internal(String rfqInternal) {
		rfq_internal = rfqInternal;
	}
	public String getRfq_routing_history() {
		return rfq_routing_history;
	}
	public void setRfq_routing_history(String rfqRoutingHistory) {
		rfq_routing_history = rfqRoutingHistory;
	}
	public String getRfq_loc() {
		return rfq_loc;
	}
	public void setRfq_loc(String rfqLoc) {
		rfq_loc = rfqLoc;
	}
	public String getRfq_date() {
		return rfq_date;
	}
	public void setRfq_date(String rfqDate) {
		rfq_date = rfqDate;
	}
	public String getRfq_dock_date() {
		return rfq_dock_date;
	}
	public void setRfq_dock_date(String rfqDockDate) {
		rfq_dock_date = rfqDockDate;
	}
	public String getRfq_state() {
		return rfq_state;
	}
	public void setRfq_state(String rfqState) {
		rfq_state = rfqState;
	}
	
	@Override
	public String toString() {
		return "Spotic_RfqBean [fk_apa_emp_id=" + fk_apa_emp_id
				+ ", fk_customer_id=" + fk_customer_id + ", fk_ppa_emp_id="
				+ fk_ppa_emp_id + ", fk_sp_emp_id=" + fk_sp_emp_id
				+ ", rfq_alternative=" + rfq_alternative + ", rfq_cost="
				+ rfq_cost + ", rfq_cust_part_no=" + rfq_cust_part_no
				+ ", rfq_date=" + rfq_date + ", rfq_dc=" + rfq_dc
				+ ", rfq_dock_date=" + rfq_dock_date + ", rfq_id=" + rfq_id
				+ ", rfq_internal=" + rfq_internal + ", rfq_loc=" + rfq_loc
				+ ", rfq_mfg=" + rfq_mfg + ", rfq_packaging=" + rfq_packaging
				+ ", rfq_part_no=" + rfq_part_no + ", rfq_quantity="
				+ rfq_quantity + ", rfq_resale=" + rfq_resale
				+ ", rfq_routing_history=" + rfq_routing_history
				+ ", rfq_state=" + rfq_state + ", rfq_target_price="
				+ rfq_target_price + "]";
	}
}
