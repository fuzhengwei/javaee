package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model._Sparameter;

public interface Sparameter{
	
	/**
	 * ��
	 */
	public boolean doInster(_Sparameter alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(ArrayList<_Sparameter> obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Sparameter> doSelect();
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Sparameter> doSelect(ArrayList<_Sparameter> alobj);
	
}
