package com.aps.db.model;
/**
 * emp������ͼ
 * @author Administrator
 */
public class V_EmpDetail extends FenPage{

	/*��ͼ�����漰�����ĸ���*/
	private _Emp emp;
	private _Authority authority;
	private _Dpoint dpoint;
	private _Drange drange;
	
	
	public _Emp getEmp() {
		return emp;
	}
	public void setEmp(_Emp emp) {
		this.emp = emp;
	}
	public _Authority getAuthority() {
		return authority;
	}
	public void setAuthority(_Authority authority) {
		this.authority = authority;
	}
	public _Dpoint getDpoint() {
		return dpoint;
	}
	public void setDpoint(_Dpoint dpoint) {
		this.dpoint = dpoint;
	}
	public _Drange getDrange() {
		return drange;
	}
	public void setDrange(_Drange drange) {
		this.drange = drange;
	}
	
	
}
