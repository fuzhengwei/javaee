package com.aps.db.model;
/**
 * ���͵�Ա��Ȩ�������
 * @author Administrator
 *
 */
public class _Dea {
	/*6
	 *���͵������ aps_dea dea
	SQL> create table aps_dea(
	  2  deaid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  fk_eid number(10) references aps_emp(eid),
	  5  fk_auid number(10) references aps_authority(auid));
	 */

	private String deaid;		//����Ա��Ȩ���ۺϱ�id
	private String fk_dpid;	//���͵����
	private String fk_eid;		//Ա�����
	private String fk_auid;	//Ȩ�����
	public String getDeaid() {
		return deaid;
	}
	public void setDeaid(String deaid) {
		this.deaid = deaid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getFk_eid() {
		return fk_eid;
	}
	public void setFk_eid(String fkEid) {
		fk_eid = fkEid;
	}
	public String getFk_auid() {
		return fk_auid;
	}
	public void setFk_auid(String fkAuid) {
		fk_auid = fkAuid;
	}
}
