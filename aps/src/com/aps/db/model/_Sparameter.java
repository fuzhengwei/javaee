package com.aps.db.model;

public class _Sparameter {
	/*2
	 *ϵͳ��������� aps_sparameter system parameter
	SQL> create table aps_sparameter(
	  2  spid number(10) primary key,
	  3  spinto number(3) not null,
	  4  spof number(3) not null,
	  5  spdeletetime number(3) not null,
	  6  spfirstkg number(5) not null,
	  7  spfirstvo number(5) not null);
	 
	 */
	private String spid;		//ϵͳ��id
	private String spinto;		//�ֳɱ�������
	private String spof;		//���ñ��۷ѱ���
	private String spdeletetime;//����ϵͳ�Զ�ɾ������
	private String spfirstkg;	//�׹�������
	private String spfirstvo;	//����������
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getSpinto() {
		return spinto;
	}
	public void setSpinto(String spinto) {
		this.spinto = spinto;
	}
	public String getSpof() {
		return spof;
	}
	public void setSpof(String spof) {
		this.spof = spof;
	}
	public String getSpdeletetime() {
		return spdeletetime;
	}
	public void setSpdeletetime(String spdeletetime) {
		this.spdeletetime = spdeletetime;
	}
	public String getSpfirstkg() {
		return spfirstkg;
	}
	public void setSpfirstkg(String spfirstkg) {
		this.spfirstkg = spfirstkg;
	}
	public String getSpfirstvo() {
		return spfirstvo;
	}
	public void setSpfirstvo(String spfirstvo) {
		this.spfirstvo = spfirstvo;
	}
}
