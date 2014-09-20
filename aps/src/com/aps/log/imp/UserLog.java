package com.aps.log.imp;

import java.util.Date;
import com.aps.log.ILog;
 

/**
 * �û���־
 * @author Administrator
 *
 */
public class UserLog implements ILog {

	private static WriteFile wFile = new WriteFile();
	private static StringBuffer sb = new StringBuffer();
	private static String R = "\r\n";
	private static UserLog ulog = new UserLog();
	
	//����ģʽ
	public static UserLog getUserLogSingleton(){
		if(null != ulog){
			return ulog;
		}else{
			return new UserLog();
		}
	}
	
	//��ֹ�û�ʵ����
	private UserLog(){}
	
	/**
	 * ������־
	 */
	public void doSaveLog(String str) {
		sb.append(R)
		  .append(new Date())
		  .append(R)
		  .append(str)
		  .append(R)
		  .append("---------------");
		sb.trimToSize();
		wFile.doWF(sb.toString());
		sb.delete(0, sb.toString().length());
	}

	
	
}
