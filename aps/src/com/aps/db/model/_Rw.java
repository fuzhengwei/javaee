package com.aps.db.model;
/**
 * ·��;���� �����
 * @author Administrator
 *
 */
public class _Rw {
	/*9
	 *·��;���� �����rw aps_rw
	SQL> create table aps_rw(
	  2  rwid number(10) primary key,
	  3  fk_rtid number(10) references aps_route(rtid),
	  4  rwroutend varchar2(100));
	 */

	private String rwid;		//·��;����id
	private String fk_rtid;	//·�����
	private String rwroutend;	//·��;��
	public String getRwid() {
		return rwid;
	}
	public void setRwid(String rwid) {
		this.rwid = rwid;
	}
	public String getFk_rtid() {
		return fk_rtid;
	}
	public void setFk_rtid(String fkRtid) {
		fk_rtid = fkRtid;
	}
	public String getRwroutend() {
		return rwroutend;
	}
	public void setRwroutend(String rwroutend) {
		this.rwroutend = rwroutend;
	}
}
