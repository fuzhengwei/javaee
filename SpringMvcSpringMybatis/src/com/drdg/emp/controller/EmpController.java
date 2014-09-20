package com.drdg.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.drdg.emp.bean.EmpBean;
import com.drdg.emp.service.IEmpService;

@Controller
@RequestMapping("/emp/")
public class EmpController {

	private IEmpService empService;

	public IEmpService getEmpService() {
		return empService;
	}

	@Autowired
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	
	@RequestMapping("doInsertEmp")
	public ModelAndView doInsertEmp(@ModelAttribute EmpBean empBean){
		
		int rc = empService.doInsertEmp(empBean);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", "doInsertEmp->"+rc);
		
		return mv;
	}
	
	@RequestMapping("doInsertEmpSelective")
	public ModelAndView doInsertEmpSelective(@ModelAttribute EmpBean empBean){
		
		int rc = empService.doInsertEmpSelective(empBean);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", "doInsertEmpSelective->"+rc);
		
		return mv;
		
	}
	
	@RequestMapping("doDeleteEmpById")
	public ModelAndView doDeleteEmpById(@RequestParam String empId){
		empService.doDeleteEmpById(Integer.parseInt(empId));
		List<EmpBean> empList = empService.doGetEmpList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view/emp/emplist");
		mv.addObject("modelList", empList);
		return mv;
	}
	
	@RequestMapping("doGetEmpList")
	public ModelAndView doGetEmpList(){
		List<EmpBean> empList = empService.doGetEmpList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view/emp/emplist");
		mv.addObject("modelList", empList);
		return mv;
	}
	
	@RequestMapping("doGetEmpById")
	public ModelAndView doGetEmpById(@RequestParam String empId){
		ModelAndView mv = new ModelAndView();
		EmpBean empBean = empService.doGetEmpById(Integer.parseInt(empId));
		mv.setViewName("view/emp/empupdate");
		mv.addObject("model", empBean);
		return mv;
	}
}
