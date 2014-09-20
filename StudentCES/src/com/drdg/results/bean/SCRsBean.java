package com.drdg.results.bean;

/*
 * select 
 * a.res_id res_id,
 * b.cou_name cou_name,
 * c.stu_name stu_name,
 * a.res_fraction res_fraction,
 * a.res_entrydate res_entrydate,
 * a.res_state res_state,
 * a.res_remark res_remark 
 * from dbo.results a,dbo.course b,dbo.student c where a.fk_cou_id = b.cou_id and a.fk_stu_id = c.stu_id
 */
public class SCRsBean {

	private String res_id;
	private String cou_name;
	private String stu_name;
	private String res_fraction;
	private String res_entrydate;
	private String res_state;
	private String res_remark;
	private String cat_name;
	
	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String resId) {
		res_id = resId;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String couName) {
		cou_name = couName;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	public String getRes_fraction() {
		return res_fraction;
	}

	public void setRes_fraction(String resFraction) {
		res_fraction = resFraction;
	}

	public String getRes_entrydate() {
		return res_entrydate;
	}

	public void setRes_entrydate(String resEntrydate) {
		res_entrydate = resEntrydate;
	}

	public String getRes_state() {
		return res_state;
	}

	public void setRes_state(String resState) {
		res_state = resState;
	}

	public String getRes_remark() {
		return res_remark;
	}

	public void setRes_remark(String resRemark) {
		res_remark = resRemark;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String catName) {
		cat_name = catName;
	}

}
