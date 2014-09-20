package com.drdg.results.bean;

/*
 * SELECT [res_id]
 ,[fk_cou_id]
 ,[fk_stu_id]
 ,[res_fraction]
 ,[res_entrydate]
 ,[res_state]
 ,[res_remark]
 FROM [StudentCES].[dbo].[results]
 ���	�γ����	�γ�����	ѧ��	����	¼��ʱ��	״̬	��ע
 */
public class ResultsBean {
	
	private String res_id;
	private String fk_cou_id;
	private String fk_stu_id;
	private String res_fraction;
	private String res_entrydate;
	private String res_state; // 0Ϊ�೤¼�������֮���ֵ�Ա������״̬Ϊ1��ѧ���ſ��Բ�ѯ
	private String res_remark;

	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String resId) {
		res_id = resId;
	}

	public String getFk_cou_id() {
		return fk_cou_id;
	}

	public void setFk_cou_id(String fkCouId) {
		fk_cou_id = fkCouId;
	}

	public String getFk_stu_id() {
		return fk_stu_id;
	}

	public void setFk_stu_id(String fkStuId) {
		fk_stu_id = fkStuId;
	}

	public String getRes_fraction() {
		return res_fraction;
	}

	public void setRes_fraction(String resFaction) {
		res_fraction = resFaction;
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

}
