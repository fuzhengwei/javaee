package com.cl.xiaofu.action;

import java.util.List;

import com.cl.xiaofu.dao.mybankDB;
import com.cl.xiaofu.dao.userDB;
import com.cl.xiaofu.model._cltable;
import com.cl.xiaofu.model._usertable;
import com.opensymphony.xwork2.ActionSupport;

public class ClUserAction extends ActionSupport{
	
	private _usertable usertable;
	private userDB udb = new userDB();
	private mybankDB mydb = new mybankDB();
	private String loginMessage;
	private String loginName;
	private String loginClMessage;//彩礼信息表
	private List<_cltable> list;
	
	public String add() {
		usertable.setUserName(udb.doGbk(usertable.getUserName()));
		udb.addUser(usertable);
		return SUCCESS;
	}
	
	public String login(){
		loginMessage = udb.selectUser(usertable);
		if(loginMessage.equals("errorPw")){
			loginMessage = "密码错误";
			return ERROR;
		}else if(loginMessage.equals("errorUser")){
			loginMessage = "没有当前用户";
			return ERROR;
		}else{
			loginName = loginMessage;
			//获取登录之后的当前用户的彩礼信息
			loginClMessage = mydb.doUserClMessage(loginName);
			list = mydb.doWhatTime(loginName);
			return SUCCESS;
		}
	}
	
	public _usertable getUsertable() {
		return usertable;
	}

	public void setUsertable(_usertable usertable) {
		this.usertable = usertable;
	}

	public userDB getUdb() {
		return udb;
	}

	public void setUdb(userDB udb) {
		this.udb = udb;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginClMessage() {
		return loginClMessage;
	}

	public void setLoginClMessage(String loginClMessage) {
		this.loginClMessage = loginClMessage;
	}

	public mybankDB getMydb() {
		return mydb;
	}

	public void setMydb(mybankDB mydb) {
		this.mydb = mydb;
	}

	public List<_cltable> getList() {
		return list;
	}

	public void setList(List<_cltable> list) {
		this.list = list;
	}
}
