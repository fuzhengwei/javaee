package com.aps.db.model;

public class _Customer extends FenPage{
	/*1
	 *�ͻ������ aps_customer
	 *SQL> create table aps_customer(
	  2  ctid number(10) primary key,
	  3  cnickname varchar2(20) not null,
	  4  cname varchar2(20) not null,
	  5  csex varchar2(2) default '��' check (csex in ('��','Ů')),
	  6  cpwd varchar2(15) not null,
	  7  ctel number(11) not null,
	  8  cemail varchar2(20),
	  9  cbirthday date,
	 10  caddress varchar2(30));
	 */

	private String ctid;		//�û�id
	private String cnickname;	//�û��ǳ�
	private String cname;		//�û�����
	private String csex;		//�û��Ա�
	private String cpwd;		//�û�����
	private String ctel;		//�û��绰
	private String cemail;		//�û�����
	private String cbirthday;	//�û�����
	private String caddress;	//�û����ڵ�
	public String getCtid() {
		return ctid;
	}
	public void setCtid(String ctid) {
		this.ctid = ctid;
	}
	public String getCnickname() {
		return cnickname;
	}
	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCbirthday() {
		return cbirthday;
	}
	public void setCbirthday(String cbirthday) {
		this.cbirthday = cbirthday;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
}
