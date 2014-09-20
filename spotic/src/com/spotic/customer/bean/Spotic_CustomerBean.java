package com.spotic.customer.bean;

public class Spotic_CustomerBean {

	private String customer_id;			//客户ID 			
	private String customer_company;	//客户公司			
	private String customer_name;		//客户姓名			
	private String customer_phone;		//客户电话			
	private String customer_fax;		//客户传真			
	private String customer_email;		//客户邮箱			
	private String customer_type;		//客户类型[1本公司库存、2客户、3供应商、4市场]			
	private String customer_remarks;	//客户备注[备注里标明是什么用户等一些其他信息]			
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customerId) {
		customer_id = customerId;
	}
	public String getCustomer_company() {
		return customer_company;
	}
	public void setCustomer_company(String customerCompany) {
		customer_company = customerCompany;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customerName) {
		customer_name = customerName;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customerPhone) {
		customer_phone = customerPhone;
	}
	public String getCustomer_fax() {
		return customer_fax;
	}
	public void setCustomer_fax(String customerFax) {
		customer_fax = customerFax;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customerEmail) {
		customer_email = customerEmail;
	}
	public String getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(String customerType) {
		customer_type = customerType;
	}
	public String getCustomer_remarks() {
		return customer_remarks;
	}
	public void setCustomer_remarks(String customerRemarks) {
		customer_remarks = customerRemarks;
	}
}
