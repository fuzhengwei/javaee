package com.spotic.customer.dao;

import java.util.ArrayList;

import com.stack.bean.PageBean;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class Spotic_CustomerDao implements IReflctQueryDao{

	private static IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.customer.bean.Spotic_CustomerBean");
	
	public boolean doDeleteModelById(String modelId) {
		return rqd.doDeleteModelById(modelId);
	}

	public boolean doInsertModel(Object objBean) {
		return rqd.doInsertModel(objBean);
	}

	public Object doSelectModelById(String modelId) {
		return rqd.doSelectModelById(modelId);
	}

	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		return rqd.doSelectModelList(pageBean);
	}

	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		return rqd.doSelectModelListBySerach(pageBean, objBean);
	}

	public boolean doUpdateModel(Object objBean) {
		return rqd.doUpdateModel(objBean);
	}

	public ArrayList<?> doSelectModelAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<?> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean) {
		return rqd.doSelectModelListBySerachForLike(pageBean, objBean);
	}

}
