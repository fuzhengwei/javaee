package com.aps.db.model;
/**
 * Ա����
 * @author Administrator
 *
 */
public class _Emp extends FenPage{
	/*4
	 *Ա���� aps_emp emp
	SQL> create table aps_emp(
	  2  eid number(10) primary key,
	  3  ename varchar2(20) not null,
	  4  esex varchar2(2) default '��' check (esex in ('��','Ů')),
	  5  eage number(3),
	  6  ebirthday date,
	  7  epa varchar2(4) default '��Ա' check (epa in('��Ա','��Ա','�޵���ʿ')),
	  8  eaddress varchar2(100) not null,
	  9  ephone number(11) not null,
	 10  eemail varchar2(20),
	 11  epost varchar2(10),
	 12  edept varchar2(10),
	 13  edindate date,
	 14  esal number(6),
	 15  estate varchar2(10),
	 16  enote varchar2(200));
	 */

	private String eid;			//Ա��id
	private String ename;		//Ա������
	private String esex;		//Ա���Ա�
	private String eage;		//Ա������
	private String ebirthday;	//Ա������
	private String epa;			//������ò
	private String eaddress;	//��ַ
	private String ephone;		//�ֻ���
	private String eemail;		//email
	private String epost;		//ְλ
	private String edept;		//����
	private String eindate;		//��ְʱ��
	private String esal;		//нˮ
	private String estate;		//״̬
	private String enote;		//��ע
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getEbirthday() {
		return ebirthday;
	}
	public void setEbirthday(String ebirthday) {
		this.ebirthday = ebirthday;
	}
	public String getEpa() {
		return epa;
	}
	public void setEpa(String epa) {
		this.epa = epa;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
	public String getEindate() {
		return eindate;
	}
	public void setEindate(String eindate) {
		this.eindate = eindate;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public String getEstate() {
		return estate;
	}
	public void setEstate(String estate) {
		this.estate = estate;
	}
	public String getEnote() {
		return enote;
	}
	public void setEnote(String enote) {
		this.enote = enote;
	}
}
