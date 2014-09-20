package com.drdg.emp.bean;

public class EmpBean {
	
	private Integer empId;
	private String empName;
	private String empAge;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null :empName.trim();
	}

	public String getEmpAge() {
		return empAge;
	}

	public void setEmpAge(String empAge) {
		this.empAge = empAge == null ? null : empAge.trim();
	}

	@Override
	public String toString() {
		return "EmpBean [empAge=" + empAge + ", empId=" + empId + ", empName="
				+ empName + "]";
	}

}
