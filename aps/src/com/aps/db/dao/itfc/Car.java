package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Car;

public interface Car{
	
	/**
	 * ��
	 */
	public boolean doInster(ArrayList<_Car> alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(ArrayList<_Car> obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Car> doSelect();
	
	/**
	 * ��ҳ��ʽ��ѯ
	 */

	public ArrayList<_Car> doSelectPage(FenPage fpage);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Car> doSelect(_Car car);
	
	
	
}
