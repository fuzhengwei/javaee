package com.drdg.department.service;

import java.util.List;

import com.drdg.department.bean.DepartmentBean;

public interface IDepartmentService {

	List<DepartmentBean> doGetDepartmentList();
	
}
