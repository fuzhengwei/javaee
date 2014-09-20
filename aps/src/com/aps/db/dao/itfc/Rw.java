package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;

public interface Rw{
	
	/**
	 * ��
	 */
	public boolean doInster(_Rw alobj);
	
	/**
	 * ɾ
	 */
	public boolean doDelete(String id);	
	
	/**
	 * ��
	 */
	public boolean doUpdate(_Rw obj);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��
	 */
	public ArrayList<_Rw> doSelect(FenPage page);
	
	/**
	 * ��
	 * ����������ҳ��ʽ��ȫ��(���ݴ������Ĳ������鴮������ִ��)
	 */
	public ArrayList<_Rw> doSelect(_Rw alobj);
	
	/**
	 * ��ѯ��·�������Ϣ��װ�ص����ͷ�Χҳ��
	 */
	public ArrayList<_Route> doSelectPointToRw();
	
}
