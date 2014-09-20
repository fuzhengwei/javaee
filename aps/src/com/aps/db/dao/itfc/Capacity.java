package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.CapacityS;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Capacitys;
import com.aps.db.model._Capacity;

public interface Capacity{
	
	/**
	 * ��
	 */
	public boolean doInster(_Capacity alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Capacity obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<V_Capacitys> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Capacity> doSelect(_Capacity alobj);
	
	/**
	 * װ����Ϣ����������ҳ��
	 */
	public ArrayList<CapacityS> doGetAllToCap();
}
