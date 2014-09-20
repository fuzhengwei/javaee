package com.spotic.emp.bean;

import com.stack.bean.PageBean;

/**
 * 
 * @author fuzhengwei
 *  员工表 emp
	emp_id		自增ID
	emp_name	员工姓名
	emp_pwd		登录密码
	emp_phone	联系电话	
	emp_creatdate	创建日期
	emp_power	权限值1 2 3【1表示最高管理员，2普通员工】
	emp_state	状态0 1【表示可以该用户可以使用或者不可以】
	emp_i18n	国际化【en_US zh_CN】
	emp_remarks	备注信息
 */
public class Spotic_EmpBean extends PageBean{
	
	private String emp_id;
	private String emp_name;
	private String emp_pwd;
	private String emp_phone;
	private String emp_createdate;
	private String emp_power;
	private String emp_state;
	private String emp_i18n;
	private String emp_remarks;
	
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
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String empPwd) {
		emp_pwd = empPwd;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String empPhone) {
		emp_phone = empPhone;
	}
	public String getEmp_createdate() {
		return emp_createdate;
	}
	public void setEmp_createdate(String empCreatedate) {
		emp_createdate = empCreatedate;
	}
	public String getEmp_power() {
		return emp_power;
	}
	public void setEmp_power(String empPower) {
		emp_power = empPower;
	}
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String empState) {
		emp_state = empState;
	}
	public String getEmp_i18n() {
		return emp_i18n;
	}
	public void setEmp_i18n(String empI18n) {
		emp_i18n = empI18n;
	}
	public String getEmp_remarks() {
		return emp_remarks;
	}
	public void setEmp_remarks(String empRemarks) {
		emp_remarks = empRemarks;
	}
}
