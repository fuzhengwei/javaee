package com.drdg.department.dao;

import java.util.List;

import com.drdg.department.bean.DepartmentBean;

public interface DepartmentDao {

	List<DepartmentBean> doGetDepartmentList();
	
}
