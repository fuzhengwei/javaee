package com.cl.xiaofu.action;

import java.util.List;

import com.cl.xiaofu.dao.mybankDB;
import com.cl.xiaofu.model._cltable;
import com.opensymphony.xwork2.ActionSupport;

public class ClMybankAction extends ActionSupport {
	
	private mybankDB mydb = new mybankDB();
	private List<Object[]> list;
	private List<_cltable> listClMess;
	private String clMessage;
	private String clTime;//�д�   ʱ��
	private String clWhat;//�д� �¼�
	private String clName;//��¼������
	private String pageCount;//�ֶ���ҳ
	private int pageNumber = 0;//��ʼҳΪ0
	private int clMoneySum = 0;//�ܼƵ�ǰҳ��Ǯ����
	private String pageTopBot;//��һҳ������һҳ
	private _cltable ct;
	private String[] NameMoney;
	private String[] checkId;//ɾ����id
	
	//�鿴��
	public String lookList() {
		list = mydb.doGetUserMessNumber(mydb.doGbk(clName), mydb.doGbk(clWhat), clTime);
		pageCount = "" + (1+Integer.parseInt(list.get(0)[1].toString()) / 6); 
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		//��ҳ����
		if("top".equals(pageTopBot)){
			if(pageNumber > 0){
				pageNumber --;
			}else{
				pageNumber = 0;
			}
		}else if("bot".equals(pageTopBot)){
			if(pageNumber < Integer.parseInt(pageCount)-1){
				pageNumber ++;
			}else{
				pageNumber = Integer.parseInt(pageCount) - 1;
			}
		}else if("bb".equals(pageTopBot)){
		   	pageNumber -= 1;
		}
		listClMess = mydb.doPage(pageNumber, clName, clWhat, clTime);//��ҳ
		for(_cltable ct:listClMess){
			clMoneySum += Integer.parseInt(ct.getClMoney());
		}
		return SUCCESS;
	}
	//������ҳ��
	public String updateList() {
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		listClMess = mydb.doAllSum(clName, clWhat, clTime);
		return SUCCESS;
	}
	//������µ���������
	public String update(){
		clName = mydb.doGbk(ct.getClHome());
		clWhat = mydb.doGbk(ct.getClWhat());
		clTime = ct.getClTime();
		
		ct.setClHome(clName);
		ct.setClWhat(clWhat);
		ct.setClWho(mydb.doGbk(ct.getClWho()));
		
		mydb.doUpdate(ct);
		listClMess = mydb.doAllSum(clName, clWhat, clTime);
		
		return "doList";
	}
	//��ȡlist�б�װ����deleteListҳ��
	public String deleteList() {
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		clTime = mydb.doGbk(clTime);
		listClMess = mydb.doList(clName, clWhat, clTime);
		return SUCCESS;
	}
	//����ɾ����
	public String delete() {
		mydb.doDeleteList(checkId);
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		clTime = mydb.doGbk(clTime);
		listClMess = mydb.doList(clName, clWhat, clTime);
		return "doList";
	}
	
	public String createList() {
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		clTime = mydb.doGbk(clTime);
		return SUCCESS;
	}
	
	public String create(){
		clName = mydb.doGbk(clName);
		clWhat = mydb.doGbk(clWhat);
		clTime = mydb.doGbk(clTime);
		
		for(int i = 0; i < NameMoney.length; i ++){
		    _cltable ctAdd = new _cltable();
		    ctAdd.setClHome(clName);ctAdd.setClWhat(clWhat);ctAdd.setClTime(clTime);
		    ctAdd.setClWho(mydb.doGbk(NameMoney[i].substring(0,NameMoney[i].indexOf("*"))));
		    ctAdd.setClMoney(NameMoney[i].substring(NameMoney[i].indexOf("*")+1));
			mydb.doAddList(ctAdd);
		}
		
		return "doList";
	}
	
	public mybankDB getMydb() {
		return mydb;
	}

	public void setMydb(mybankDB mydb) {
		this.mydb = mydb;
	}

	public String getClMessage() {
		return clMessage;
	}

	public void setClMessage(String clMessage) {
		this.clMessage = clMessage;
	}

	public String getClTime() {
		return clTime;
	}

	public void setClTime(String clTime) {
		this.clTime = clTime;
	}

	public String getClWhat() {
		return clWhat;
	}

	public void setClWhat(String clWhat) {
		this.clWhat = clWhat;
	}

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	public List<Object[]> getList() {
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public List<_cltable> getListClMess() {
		return listClMess;
	}

	public void setListClMess(List<_cltable> listClMess) {
		this.listClMess = listClMess;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getClMoneySum() {
		return clMoneySum;
	}

	public void setClMoneySum(int clMoneySum) {
		this.clMoneySum = clMoneySum;
	}

	public String getPageTopBot() {
		return pageTopBot;
	}

	public void setPageTopBot(String pageTopBot) {
		this.pageTopBot = pageTopBot;
	}
	public _cltable getCt() {
		return ct;
	}
	
	public String[] getCheckId() {
		return checkId;
	}
	public void setCheckId(String[] checkId) {
		this.checkId = checkId;
	}
	public void setCt(_cltable ct) {
		this.ct = ct;
	}
	public String[] getNameMoney() {
		return NameMoney;
	}
	public void setNameMoney(String[] nameMoney) {
		NameMoney = nameMoney;
	}
	
	
	
}
