package com.aps.db.model;

/**
 * ��vo���������͵㡢���ͷ�Χ��·�ߡ�·��;���㡢Ա����˾����
 * @author ����ί
 */
public class CapacityS {

	private _Dpoint 	dpoint;			//���͵�
	private _Drange 	drange;			//���ͷ�Χ
	private _Route 		route;			//·��
	private _Rw 		rw;				//·��;����
	private _Car 		car;			//����
	private V_EmpDetail empDetail;		//Ա����ϸ��Ϣ
	
	public _Dpoint getDpoint() {
		return dpoint;
	}
	public void setDpoint(_Dpoint dpoint) {
		this.dpoint = dpoint;
	}
	public _Drange getDrange() {
		return drange;
	}
	public void setDrange(_Drange drange) {
		this.drange = drange;
	}
	public _Route getRoute() {
		return route;
	}
	public void setRoute(_Route route) {
		this.route = route;
	}
	public _Rw getRw() {
		return rw;
	}
	public void setRw(_Rw rw) {
		this.rw = rw;
	}
	public V_EmpDetail getEmpDetail() {
		return empDetail;
	}
	public void setEmpDetail(V_EmpDetail empDetail) {
		this.empDetail = empDetail;
	}
	public _Car getCar() {
		return car;
	}
	public void setCar(_Car car) {
		this.car = car;
	}
}
