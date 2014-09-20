package com.stack.bean;

public class PageBean {

	private int firstResult = 1; //设置查询起点
	private int maxResult = 20;  //设置每页最大页数
	
	private int pageNow = 1;	//当前第几页
	private int pageNum = 0;	//共有多少条数据	
	private int pageCount = 0;	//共有多少页数据
	
	public PageBean(){
		
	}
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	public void setPageNow(String pageNow){
		this.pageNow = Integer.parseInt(pageNow);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		if((pageNum % maxResult)!=0){
			this.pageCount = this.pageNum / maxResult + 1;
		}else{
			this.pageCount = this.pageNum / maxResult;
		}
	}
	
	public void setPageNum(String pageNum) {
		this.pageNum = Integer.parseInt(pageNum);
		if((this.pageNum % maxResult)!=0){
			this.pageCount = this.pageNum / maxResult + 1;
		}else{
			this.pageCount = this.pageNum / maxResult;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public PageBean(int firstResult){
		this.firstResult = firstResult;
	}
	
	public PageBean(int firstResult,int maxResult){
		this.firstResult = firstResult;
		this.maxResult = maxResult;
	}
	
	public int getFirstResult() {
		if(firstResult > 1){
			return --firstResult * maxResult;
		}else{
			return 0;
		}
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	
	public void setFirstResult(String firstResult){
		if(null == firstResult){
			firstResult = "1";
		}
		this.firstResult = Integer.parseInt(firstResult);
	}

	public int getMaxResult() {
		if(firstResult > 1){
			return maxResult + --firstResult * maxResult;
		}else{
			return maxResult;
		}
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

}
