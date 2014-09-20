package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model.V_PdLogin;
import com.aps.db.model._Authority;

public interface Authority{
	
	/**
	 * ��
	 */
	public boolean doInster(_Authority alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Authority obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<V_PdLogin> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Authority> doSelect(_Authority alobj);
	
}
