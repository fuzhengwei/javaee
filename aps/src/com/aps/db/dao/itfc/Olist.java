package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Olist;

public interface Olist{
	
	/**
	 * ��
	 */
	public boolean doInster(_Olist alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Olist obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Olist> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Olist> doSelect(_Olist alobj);
	
}
