package com.drdg.category.bean;

/*
 * SELECT TOP 1000 [cat_id]
 ,[cat_name]
 ,[cat_weight]
 ,[cat_remark]
 FROM [StudentCES].[dbo].[category]
 序号	课程分类名称	课程权重	备注
 */
public class CategoryBean {

	private String cat_id;
	private String cat_name;
	private String cat_weight;
	private String cat_remark;

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String catId) {
		cat_id = catId;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String catName) {
		cat_name = catName;
	}

	public String getCat_weight() {
		return cat_weight;
	}

	public void setCat_weight(String catWeight) {
		cat_weight = catWeight;
	}

	public String getCat_remark() {
		return cat_remark;
	}

	public void setCat_remark(String catRemark) {
		cat_remark = catRemark;
	}

}
