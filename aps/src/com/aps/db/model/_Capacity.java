package com.aps.db.model;
/**
 * ������־û�
 * @author Administrator
 *
 */
public class _Capacity {
	/*11
	 *������ aps_capacity capacity
	SQL> create table aps_capacity(
	  2  capid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  fk_rtid number(10) references aps_route(rtid),
	  5  fk_cid number(10) references aps_car(cid),
	  6  fk_eid number(10) references aps_emp(eid),
	  7  capstate varchar2(20));
	 */

	private String capid; 		//������id
	private String fk_dpid;		//���͵����aps_dpoint
	private String fk_rtid;		//·�����aps_route
	private String fk_cid;		//�������aps_car
	private String fk_eid;		//Ա����˾������aps_emp
	private String capstate;	//״̬
	public String getCapid() {
		return capid;
	}
	public void setCapid(String capid) {
		this.capid = capid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getFk_rtid() {
		return fk_rtid;
	}
	public void setFk_rtid(String fkRtid) {
		fk_rtid = fkRtid;
	}
	public String getFk_cid() {
		return fk_cid;
	}
	public void setFk_cid(String fkCid) {
		fk_cid = fkCid;
	}
	public String getFk_eid() {
		return fk_eid;
	}
	public void setFk_eid(String fkEid) {
		fk_eid = fkEid;
	}
	public String getCapstate() {
		return capstate;
	}
	public void setCapstate(String capstate) {
		this.capstate = capstate;
	}
}
