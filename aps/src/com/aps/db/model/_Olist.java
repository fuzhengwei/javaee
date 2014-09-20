package com.aps.db.model;
/**
 * ����
 * @author Administrator
 *
 */
public class _Olist extends FenPage{
	/*12
	 *������ aps_olist order list
	SQL> create or replace table aps_olist(
  2  olid number(10) primary key,
  3   olno number(20) unique not null,
  4  olname varchar2(20) not null,
  5  olsendtel number(11) not null,
  6  olsendaddress varchar2(100) not null,
  7  olsendcode number(6) not null,
  8  olsendemail varchar2(50) not null,
  9  olinname varchar2(20) not null,
 10  olintel number(11) not null,
 11  olinaddress varchar2(100) not null,
 12  olincode number(6) not null,
 13  olgoodsname varchar2(50) not null,
 14  olgoodstype varchar2(20) not null,
 15  olgoodsnum number(5) not null,
 16  olgoodsweight number(5,2) not null,
 17  olgoodsaddress varchar2(100) not null,
 18  oldate date not null,
 19  olingoodsadd varchar2(100) not null,
 20  olins number(10),
 21  olsnotice varchar2(2) default '��' check (olsnotice in('��','��')),
 22  olpays varchar2(10) not null,
 23  olnote varchar2(200));
	 */

	private String olid;		//����id
	private String olno;		//�������
	private String olname;		//����������
	private String olsendtel;	//�����˵绰
	private String olsendaddress;	//�����˵�ַ
	private String olsendcode;	//�������ʱ�
	private String olsendemail;	//����������
	private String olinname;	//�ջ�������
	private String olintel;	//�ջ��˵绰
	private String olinaddress;	//�ջ��˵�ַ
	private String olincode;	//�ջ����ʱ�
	private String olgoodsname;	//��������
	private String olgoodstype;	//��������
	private String olgoodsnum;	//�������
	private String olgoodsweight;	//��������
	private String olgoodsaddress;	//����վ��
	private String oldate;		//�µ�ʱ�䣨ϵͳ��ʱ�䣩
	private String olingoodsadd;	//�ջ�վ��
	private String olins;		//���ռ�ֵ
	private String olsnotice;	//����֪ͨ
	private String olpays;		//���ʽ
	private String olnote;		//��ע��Ϣ
	public String getOlid() {
		return olid;
	}
	public void setOlid(String olid) {
		this.olid = olid;
	}
	public String getOlno() {
		return olno;
	}
	public void setOlno(String olno) {
		this.olno = olno;
	}
	public String getOlname() {
		return olname;
	}
	public void setOlname(String olname) {
		this.olname = olname;
	}
	public String getOlsendtel() {
		return olsendtel;
	}
	public void setOlsendtel(String olsendtel) {
		this.olsendtel = olsendtel;
	}
	public String getOlsendaddress() {
		return olsendaddress;
	}
	public void setOlsendaddress(String olsendaddress) {
		this.olsendaddress = olsendaddress;
	}
	public String getOlsendcode() {
		return olsendcode;
	}
	public void setOlsendcode(String olsendcode) {
		this.olsendcode = olsendcode;
	}
	public String getOlsendemail() {
		return olsendemail;
	}
	public void setOlsendemail(String olsendemail) {
		this.olsendemail = olsendemail;
	}
	public String getOlinname() {
		return olinname;
	}
	public void setOlinname(String olinname) {
		this.olinname = olinname;
	}
	public String getOlintel() {
		return olintel;
	}
	public void setOlintel(String olintel) {
		this.olintel = olintel;
	}
	public String getOlinaddress() {
		return olinaddress;
	}
	public void setOlinaddress(String olinaddress) {
		this.olinaddress = olinaddress;
	}
	public String getOlincode() {
		return olincode;
	}
	public void setOlincode(String olincode) {
		this.olincode = olincode;
	}
	public String getOlgoodsname() {
		return olgoodsname;
	}
	public void setOlgoodsname(String olgoodsname) {
		this.olgoodsname = olgoodsname;
	}
	public String getOlgoodstype() {
		return olgoodstype;
	}
	public void setOlgoodstype(String olgoodstype) {
		this.olgoodstype = olgoodstype;
	}
	public String getOlgoodsnum() {
		return olgoodsnum;
	}
	public void setOlgoodsnum(String olgoodsnum) {
		this.olgoodsnum = olgoodsnum;
	}
	public String getOlgoodsweight() {
		return olgoodsweight;
	}
	public void setOlgoodsweight(String olgoodsweight) {
		this.olgoodsweight = olgoodsweight;
	}
	public String getOlgoodsaddress() {
		return olgoodsaddress;
	}
	public void setOlgoodsaddress(String olgoodsaddress) {
		this.olgoodsaddress = olgoodsaddress;
	}
	public String getOldate() {
		return oldate;
	}
	public void setOldate(String oldate) {
		this.oldate = oldate;
	}
	public String getOlingoodsadd() {
		return olingoodsadd;
	}
	public void setOlingoodsadd(String olingoodsadd) {
		this.olingoodsadd = olingoodsadd;
	}
	public String getOlins() {
		return olins;
	}
	public void setOlins(String olins) {
		this.olins = olins;
	}
	public String getOlsnotice() {
		return olsnotice;
	}
	public void setOlsnotice(String olsnotice) {
		this.olsnotice = olsnotice;
	}
	public String getOlpays() {
		return olpays;
	}
	public void setOlpays(String olpays) {
		this.olpays = olpays;
	}
	public String getOlnote() {
		return olnote;
	}
	public void setOlnote(String olnote) {
		this.olnote = olnote;
	}
}
