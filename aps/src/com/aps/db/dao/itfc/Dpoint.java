package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Car;
import com.aps.db.model._Dpoint;

public interface Dpoint{
	
	/**
	 * ��
	 */
	public boolean doInster(_Dpoint alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(ArrayList<_Dpoint> obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Dpoint> doSelect();
	
	/**
	 * ��ҳ��ʽ��ѯ
	 */
	public ArrayList<_Dpoint> doSelectPage(FenPage fpage);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Dpoint> doSelect(ArrayList<_Dpoint> alobj);
	
	/**
	 * �鿴����
	 */
	public ArrayList<V_EmpDetail> doSelectDetail(FenPage fpage);
	
}
