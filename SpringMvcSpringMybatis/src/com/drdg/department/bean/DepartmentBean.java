package com.drdg.department.bean;

public class DepartmentBean {

	private Integer dtId;
	private String dtNo;
	private String dtName;
	
	public Integer getDtId() {
		return dtId;
	}
	public void setDtId(Integer dtId) {
		this.dtId = dtId;
	}
	public String getDtNo() {
		return dtNo;
	}
	public void setDtNo(String dtNo) {
		this.dtNo = dtNo;
	}
	public String getDtName() {
		return dtName;
	}
	public void setDtName(String dtName) {
		this.dtName = dtName;
	}
	@Override
	public String toString() {
		return "DepartmentBean [dtId=" + dtId + ", dtName=" + dtName
				+ ", dtNo=" + dtNo + "]";
	}
	
}
