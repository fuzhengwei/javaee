package com.stack.util.rsq;

import java.util.ArrayList;

import com.stack.bean.PageBean;

public interface IReflctQueryDao {

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doInsertModel(java.lang.Object)
	 */
	public abstract boolean doInsertModel(Object objBean);

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doDeleteModelById(java.lang.String)
	 */
	public abstract boolean doDeleteModelById(String modelId);

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doUpdateModel(java.lang.Object)
	 */
	public abstract boolean doUpdateModel(Object objBean);

	public abstract ArrayList<?> doSelectModelListBySerachForLike(
			PageBean pageBean, Object objBean);

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelListBySerach(com.stack.bean.PageBean, java.lang.Object)
	 */
	public abstract ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean);

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelAllList
	 */
	public abstract ArrayList<?> doSelectModelAllList();

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelList(com.stack.bean.PageBean)
	 */
	public abstract ArrayList<?> doSelectModelList(PageBean pageBean);

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelById(java.lang.String)
	 */
	public abstract Object doSelectModelById(String modelId);

}