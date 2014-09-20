package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Authority;
import com.aps.db.model._Emp;

public interface Emp{
	
	/**
	 * ��
	 */
	public boolean doInster(_Emp alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Emp obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Emp> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Emp> doSelect(_Emp alobj);
	
}
