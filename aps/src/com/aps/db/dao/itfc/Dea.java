package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model._Dea;

public interface Dea{
	
	/**
	 * ��
	 */
	public boolean doInster(_Dea alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(ArrayList<_Dea> obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Dea> doSelect();
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Dea> doSelect(ArrayList<_Dea> alobj);
	
}
