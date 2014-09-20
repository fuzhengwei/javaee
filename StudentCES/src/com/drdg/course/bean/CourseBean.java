package com.drdg.course.bean;

/*
 * SELECT TOP 1000 [cou_id]
 ,[fk_cat_id]
 ,[cou_name]
 ,[cou_remark]
 FROM [StudentCES].[dbo].[course]
 */
public class CourseBean {

	private String cou_id;
	private String fk_cat_id;
	private String cou_name;
	private String cou_remark;

	public String getCou_id() {
		return cou_id;
	}

	public void setCou_id(String couId) {
		cou_id = couId;
	}

	public String getFk_cat_id() {
		return fk_cat_id;
	}

	public void setFk_cat_id(String fkCatId) {
		fk_cat_id = fkCatId;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String couName) {
		cou_name = couName;
	}

	public String getCou_remark() {
		return cou_remark;
	}

	public void setCou_remark(String couRemark) {
		cou_remark = couRemark;
	}

}
