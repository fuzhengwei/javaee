package com.aps.db.model;
/**
 * ���ͷ�Χ�յ����
 * @author Administrator
 *
 */
public class _Drange {
	/*7
	 *���ͷ�Χ�յ���� aps_drange drange
	SQL> create table aps_drange(
	  2  drid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  drend varchar(30) not null,
	  5  drfkg number(10) not null,
	  6  drokg number(10) not null);
	 */

	private String  drid;		//���ͷ�Χid
	private String  fk_dpid;		//���ͷ�Χ���
	private String  drend;		//���ͷ�Χ�յ�
	private String  drfkg;		//�׹���۸�
	private String  drokg;		//�ι���۸�
	public String getDrid() {
		return drid;
	}
	public void setDrid(String drid) {
		this.drid = drid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getDrend() {
		return drend;
	}
	public void setDrend(String drend) {
		this.drend = drend;
	}
	public String getDrfkg() {
		return drfkg;
	}
	public void setDrfkg(String drfkg) {
		this.drfkg = drfkg;
	}
	public String getDrokg() {
		return drokg;
	}
	public void setDrokg(String drokg) {
		this.drokg = drokg;
	}
}
