package com.drdg.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drdg.emp.bean.EmpBean;
import com.drdg.emp.dao.EmpDao;
import com.drdg.emp.service.IEmpService;

@Service("empService")
public class EmpService implements IEmpService {

	private EmpDao empDao;

	public EmpDao getEmpDao() {
		return empDao;
	}

	@Autowired
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public List<EmpBean> doGetEmpList() {
		return empDao.doGetEmpList();
	}

	public int doInsertEmp(EmpBean empBean) {
		return empDao.doInsertEmp(empBean);
	}

	public int doInsertEmpSelective(EmpBean empBean) {
		return empDao.doInsertEmpSelective(empBean);
	}

	public int doDeleteEmpById(Integer empId) {
		return empDao.doDeleteEmpById(empId);
	}

	public EmpBean doGetEmpById(Integer empId) {
		return empDao.doGetEmpById(empId);
	}

}
