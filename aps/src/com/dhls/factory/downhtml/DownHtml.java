/*
 * ������ҳԴ��
 */
package com.dhls.factory.downhtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.dhls.factory.RegexGetCode;
import com.dhls.factory.impl.CodeCombination;


public class DownHtml {
	
	
	RegexGetCode regexGetCode;
	CodeCombination codeCombination = new CodeCombination();
	String strLine = null;
	
	
	public DownHtml(RegexGetCode regexGetCode){
		this.regexGetCode = regexGetCode;
	}
	/**
	 * ������ҳԴ��
	 * url ��ҳ·��
	 * @throws IOException 
	 */
	public void doDownHtml(String url){
		
	
		//�����ʽ
		String urlCharest = null;
		HtmlCharest htmlCharest = new HtmlCharest();
		
		//������ҳ
		try {
			urlCharest = htmlCharest.getHtmlCharest(url);
			
			URL name=new URL(url);
			
			URLConnection conn=name.openConnection();
			conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			InputStream input=conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(input,urlCharest);
			BufferedReader buffer =new BufferedReader(isr);
			while((strLine=buffer.readLine())!=null){
				
//				System.out.println(strLine);
				//����
				filterCode(regexGetCode.getCode(strLine));
				//д��
				codeCombination.doCodeCom(regexGetCode.getCode(strLine));
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//����Դ�룬��ÿ�ʼ������ʾ
	public void filterCode(String strLineCode){
		if(strLineCode.startsWith("endCode")){
			codeCombination.doCodeCom("endCode");
			strLine.replaceAll("endCode", "");
			if(strLineCode.endsWith("startCode")){
				codeCombination.doCodeCom("startCode");
				strLine = "";
			}
		}
		if(strLineCode.startsWith("startCode")||strLineCode.endsWith("startCode")&&!strLineCode.startsWith("endCode")){
			codeCombination.doCodeCom("startCode");
			strLine = "";
		}
		
	}
	
}
