package com.aps.db.model;

/**
 * ��ҳ��
 * @author ����ί
 *
 */
public class FenPage extends SerachType{
	
	private String pageS;			//��ȡ�����ֳܷ�����ҳ
	private String pageCount;		//���ݿ�����������
	private String pageNow;			//��ǰ�ڼ�ҳ
	private String pageSize;		//ÿҳ��С����������
	private String pageNum;			//ÿҳ��ʾ����ҳ1��2��3��4��5����������ҳ
	
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getPageNow() {
		return pageNow;
	}
	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageS() {
		return pageS;
	}
	public void setPageS(String pageS) {
		this.pageS = pageS;
	}
	
}
