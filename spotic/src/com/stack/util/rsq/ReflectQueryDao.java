package com.stack.util.rsq;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;

public class ReflectQueryDao extends HandleBase implements IReflctQueryDao {

	// class
	private Class<?> loaderClass = null;
	// properties field
	private Field[] loaderField = null;
	// bean url
	private String beanUrl = "";
	// table name
	private String tableName = "";
	// page bean
	private PageBean pageBean = new PageBean();
	// assemble sql string
	private StringBuilder strInsert = new StringBuilder("INSERT INTO ");
	private StringBuilder strInsertComma = new StringBuilder(" VALUES(");
	private StringBuilder strDelete = new StringBuilder("DELETE FROM ");
	private StringBuilder strUpdate = new StringBuilder("UPDATE ");
	private StringBuilder strSelect = new StringBuilder("SELECT ");
	private StringBuilder strSelectModel = new StringBuilder(" WHERE ");
	private StringBuilder strSelectPage = new StringBuilder(" LIMIT ?,?");
	private StringBuilder strSelectSerach = new StringBuilder(" WHERE ");

	private boolean isOne = false, isAddComma = false;

	private ReflectQueryDao() {
	}

	/**
	 * 
	 * @param beanUrl
	 */
	public ReflectQueryDao(String beanUrl) {
		this.beanUrl = beanUrl;
		try {
			// The class loading
			loaderClass = Class.forName(beanUrl);
			// Get the properties of the class
			loaderField = loaderClass.getDeclaredFields();
			// get table name by beanUrl
			tableName = beanUrl.substring(beanUrl.lastIndexOf(".") + 1)
					.replace("Bean", "").toLowerCase();

			// assemble sql string
			setInsetSql();
			setDeleteSql();
			setUpdateSql();
			setSelectSql();
			setSelectModelSql();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doInsertModel(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doInsertModel(java.lang.Object)
	 */
	public boolean doInsertModel(Object objBean) {

		boolean isInsertId = false, isInsertOk = false;
		int num = 1;

		ps = super.getPs(strInsert.toString());

		for (Field f : loaderField) {
			try {
				if (isInsertId) {
					Method m_get = loaderClass.getDeclaredMethod("get"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1));

					if (null == m_get.invoke(objBean)) {
						ps.setString(num++, "");
					} else {
						ps.setString(num++, m_get.invoke(objBean).toString());
					}

				} else {
					isInsertId = true;
				}

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			isInsertOk = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}finally{
			super.close(conn);
		}

		return isInsertOk;

	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doDeleteModelById(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doDeleteModelById(java.lang.String)
	 */
	public boolean doDeleteModelById(String modelId) {
		boolean isOK = false;
		try {
			ps = super.getPs(strDelete.toString());
			ps.setString(1, modelId);
			isOK = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}finally{
			super.close(conn);
		}
		return isOK;
	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doUpdateModel(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doUpdateModel(java.lang.Object)
	 */
	public boolean doUpdateModel(Object objBean) {
		boolean isUpdateId = false, isUpdateOk = false;
		int num = 1;
		ps = super.getPs(strUpdate.toString());
		try {
			for (Field f : loaderField) {
				if (isUpdateId) {
					Method m_get = loaderClass.getDeclaredMethod("get"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1));
					ps.setString(num++, m_get.invoke(objBean).toString());
				} else {
					isUpdateId = true;
				}
			}

			String id = loaderClass
					.getDeclaredMethod(
							"get"
									+ loaderField[0].getName().substring(0, 1)
											.toUpperCase()
									+ loaderField[0].getName().substring(1))
					.invoke(objBean).toString();

			ps.setString(num, id);
			isUpdateOk = ps.executeUpdate() > 0;
			super.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}finally{
			super.close(conn);
		}

		return isUpdateOk;
	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelListBySerachForLike(com.stack.bean.PageBean, java.lang.Object)
	 */
	public ArrayList<?> doSelectModelListBySerachForLike(PageBean pageBean,
			Object objBean){
		ArrayList<Object> modelList = new ArrayList<Object>();
		strSelectSerach.delete(7, strSelectSerach.length());
		boolean isOne = true,isDeleteWhere = false;
		for (Field f : loaderField) {
			try {
				Method m_get = loaderClass.getDeclaredMethod("get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1));
				if (null != m_get.invoke(objBean)) {
					if (isOne) {
						strSelectSerach.append(f.getName()).append(" like ? ");
						isOne = false;
					} else {
						strSelectSerach.append(" and ").append(f.getName())
								.append(" like ? ");
					}
					
					isDeleteWhere = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int num = 1;
		ps = super.getPs(strSelect.toString() + (!isDeleteWhere ? "":strSelectSerach.toString())
				+ strSelectPage.toString());
		for (Field f : loaderField) {
			try {
				Method m_get = loaderClass.getDeclaredMethod("get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1));
				if (null != m_get.invoke(objBean)) {
					ps.setString(num++, "%"+m_get.invoke(objBean).toString()+"%");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ps.setInt(num++, pageBean.getFirstResult());
			ps.setInt(num, pageBean.getMaxResult());
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = Class.forName(beanUrl).newInstance();
				for (Field f : loaderField) {
					Method m_set = loaderClass.getDeclaredMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType().getName()
							.getClass());
					m_set.invoke(
							obj,
							rs.getString(f.getName().substring(0, 1)
									+ f.getName().substring(1)));
				}
				modelList.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close(conn);
		}
		return modelList;
	}
	
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelListBySerach(com.stack.bean.PageBean, java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelListBySerach(com.stack.bean.PageBean, java.lang.Object)
	 */
	public ArrayList<?> doSelectModelListBySerach(PageBean pageBean,
			Object objBean) {
		ArrayList<Object> modelList = new ArrayList<Object>();
		strSelectSerach.delete(7, strSelectSerach.length());
		boolean isOne = true,isDeleteWhere = false;
		for (Field f : loaderField) {
			try {
				Method m_get = loaderClass.getDeclaredMethod("get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1));
				if (null != m_get.invoke(objBean)) {
					if (isOne) {
						strSelectSerach.append(f.getName()).append("=?");
						isOne = false;
						isDeleteWhere = true;
					} else {
						strSelectSerach.append(" and ").append(f.getName())
								.append("=? ");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int num = 1;
		ps = super.getPs(strSelect.toString() + (!isDeleteWhere ? "":strSelectSerach.toString())
				+ strSelectPage.toString());
		for (Field f : loaderField) {
			try {
				Method m_get = loaderClass.getDeclaredMethod("get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1));
				if (null != m_get.invoke(objBean)) {
					ps.setString(num++, m_get.invoke(objBean).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ps.setInt(num++, pageBean.getFirstResult());
			ps.setInt(num, pageBean.getMaxResult());
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = Class.forName(beanUrl).newInstance();
				for (Field f : loaderField) {
					Method m_set = loaderClass.getDeclaredMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType().getName()
							.getClass());
					m_set.invoke(
							obj,
							rs.getString(f.getName().substring(0, 1)
									+ f.getName().substring(1)));
				}
				modelList.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close(conn);
		}
		return modelList;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelAllList
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelAllList()
	 */
	public ArrayList<?> doSelectModelAllList(){
		ArrayList<Object> modelList = new ArrayList<Object>();
		try {
			ps = getPs(strSelect.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = Class.forName(beanUrl).newInstance();
				for (Field f : loaderField) {
					Method m_set = loaderClass.getDeclaredMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType().getName()
							.getClass());
					m_set.invoke(
							obj,
							rs.getString(f.getName().substring(0, 1)
									+ f.getName().substring(1)));
				}
				modelList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			super.close(conn);
		}
		return modelList;
	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelList(com.stack.bean.PageBean)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelList(com.stack.bean.PageBean)
	 */
	public ArrayList<?> doSelectModelList(PageBean pageBean) {
		ArrayList<Object> modelList = new ArrayList<Object>();
		try {
			ps = getPs(strSelect.toString() + strSelectPage.toString());
			ps.setInt(1, pageBean.getFirstResult());
			ps.setInt(2, pageBean.getMaxResult());
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = Class.forName(beanUrl).newInstance();
				for (Field f : loaderField) {
					Method m_set = loaderClass.getDeclaredMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType().getName()
							.getClass());
					m_set.invoke(
							obj,
							rs.getString(f.getName().substring(0, 1)
									+ f.getName().substring(1)));
				}
				modelList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			super.close(conn);
		}
		return modelList;
	}

	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelById(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.stack.util.rsq.IReflctQueryDao#doSelectModelById(java.lang.String)
	 */
	public Object doSelectModelById(String modelId) {
		Object obj = null;
		try {
			obj = Class.forName(beanUrl).newInstance();
			ps = getPs(strSelect.toString() + strSelectModel.toString());
			ps.setString(1, modelId);
			rs = ps.executeQuery();
			if (rs.next()) {
				for (Field f : loaderField) {
					Method m_set = loaderClass.getDeclaredMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType().getName()
							.getClass());
					m_set.invoke(
							obj,
							rs.getString(f.getName().substring(0, 1)
									+ f.getName().substring(1)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			super.close(conn);
		}

		return obj;

	}

	/**
	 * assemble sql string
	 * 
	 * @param loaderField
	 */
	private void setInsetSql() {
		isOne = false;
		isAddComma = false;
		strInsert.append(tableName).append("(");
		for (Field f : loaderField) {
			if (isOne) {
				if (isAddComma) {
					// assemble insert sql string
					strInsert.append(",").append(f.getName());
					strInsertComma.append(",?");
				} else {
					// assemble insert sql string
					strInsert.append(f.getName());
					strInsertComma.append("?");
					isAddComma = true;
				}
			} else {
				isOne = true;
			}
		}
		strInsert.append(")");
		strInsertComma.append(")");
		strInsert.append(strInsertComma).trimToSize();
	}

	private void setDeleteSql() {
		strDelete.append(tableName).append(" WHERE ")
				.append(loaderField[0].getName()).append(" = ?").trimToSize();
	}

	private void setUpdateSql() {
		isOne = false;
		isAddComma = false;
		strUpdate.append(tableName).append(" SET ");
		for (Field f : loaderField) {
			if (isOne) {
				if (isAddComma) {
					// assemble update sql string
					strUpdate.append(",").append(f.getName()).append(" = ?");
				} else {
					// assemble udpate sql string
					strUpdate.append(f.getName()).append(" = ?");
					isAddComma = true;
				}
			} else {
				isOne = true;
			}
		}
		strUpdate.append(" WHERE ").append(loaderField[0].getName())
				.append(" = ?").trimToSize();

	}

	private void setSelectSql() {
		isOne = false;
		for (Field f : loaderField) {
			if (isOne) {
				strSelect.append(",").append(f.getName());
			} else {
				strSelect.append(f.getName());
				isOne = true;
			}
		}
		strSelect.append(" FROM ").append(tableName).trimToSize();
	}

	private void setSelectModelSql() {
		strSelectModel.append(loaderField[0].getName()).append(" = ?")
				.trimToSize();
	}
}
