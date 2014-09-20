package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Car;
import com.aps.db.model._Route;

public interface Route{
	
	/**
	 * ��
	 */
	public boolean doInster(_Route route);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(ArrayList<_Route> obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Route> doSelect();
	
	/**
	 * ��ҳ��ʽ��ѯ
	 */

	public ArrayList<_Route> doSelectPage(FenPage fpage);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Route> doSelect(_Route alobj);
	
	
}
