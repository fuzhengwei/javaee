package com.aps.db.model;
/**
 * ·�߹���� 
 * @author Administrator
 *
 */
public class _Route extends FenPage{
	/*8
	 *·�߹���� aps_route route
	 
	SQL> create table aps_route(
	  2  rtid number(10) primary key,
	  3  rtname varchar2(20) not null,
	  4  rtspoint varchar2(20) not null,
	  5  rtpefpkg number(5,2),
	  6  rtpeopkg number(5,2),
	  7  rtpefpvo number(5,2),
	  8  rtpeopvo number(5,2));
	 */

	private String rtid;		//·��id
	private String rtname;		//·������
	private String rtspoint;	//·�����
	private String rtpefpkg;	//�׹���۸�
	private String rtpeopkg;	//�ι���۸�
	private String rtpefpvo;	//�׹���۸�
	private String rtpeopvo;	//�ι���۸�
	private String rtEnd;		//·�߷�Χ
	
	public String getRtid() {
		return rtid;
	}
	public void setRtid(String rtid) {
		this.rtid = rtid;
	}
	public String getRtname() {
		return rtname;
	}
	public void setRtname(String rtname) {
		this.rtname = rtname;
	}
	public String getRtspoint() {
		return rtspoint;
	}
	public void setRtspoint(String rtspoint) {
		this.rtspoint = rtspoint;
	}
	public String getRtpefpkg() {
		return rtpefpkg;
	}
	public void setRtpefpkg(String rtpefpkg) {
		this.rtpefpkg = rtpefpkg;
	}
	public String getRtpeopkg() {
		return rtpeopkg;
	}
	public void setRtpeopkg(String rtpeopkg) {
		this.rtpeopkg = rtpeopkg;
	}
	public String getRtpefpvo() {
		return rtpefpvo;
	}
	public void setRtpefpvo(String rtpefpvo) {
		this.rtpefpvo = rtpefpvo;
	}
	public String getRtpeopvo() {
		return rtpeopvo;
	}
	public void setRtpeopvo(String rtpeopvo) {
		this.rtpeopvo = rtpeopvo;
	}
	public String getRtEnd() {
		return rtEnd;
	}
	public void setRtEnd(String rtEnd) {
		this.rtEnd = rtEnd;
	}
}
