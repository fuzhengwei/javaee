package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model.V_Eirs;
import com.aps.db.model._Eir;

public interface Eir{
	
	/**
	 * ��
	 */
	public boolean doInster(_Eir alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Eir obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<V_Eirs> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Eir> doSelect(_Eir alobj);
	
}
