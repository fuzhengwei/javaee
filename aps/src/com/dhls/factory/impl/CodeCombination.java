/**
 * �������
 */
package com.dhls.factory.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeCombination {
	
	private static int key = 0;
	private static String keyName = "";
	private static boolean judgeMent = false;
	
	private String codeAdd = "";
	
	//ʵ����д���ĵ��ķ���
	SaveCodeToFile saveCodeToFile = new SaveCodeToFile();
	
	public CodeCombination(){
	//	cacheCodeMap = new CacheCodeMap(); 
	}
	
	//��ϴ���
	public void doCodeCom(String strLine){
		
		if("startCode".equals(strLine)){
			codeAdd += "\r\n";
		}else if("endCode".equals(strLine)){
			//���û�л�ȡ���ļ�������ôʹ��Ĭ���ļ���
			if("".equals(keyName)){
				key ++;
				keyName = "ϵͳĬ������"+key;
			}
			judgeMent = false;//�ظ���ʼ��
			
//			System.out.println(codeAdd);
//			System.out.println(keyName);
			
			
			//д���ļ�����
			if(!"".equals(codeAdd)){
				saveCodeToFile.setJavaFileName(keyName);
				saveCodeToFile.WriteJava(codeAdd);
			}
			
			
			codeAdd = "";
			keyName = "";
			
		}else if(0 < codeAdd.length()){
			
			if(!"".equals(strLine)){
				codeAdd += strLine+"\r\n";
			}
			//���ļ��������ҵ��ļ����Ժ�ֹͣ��
			if(!judgeMent){
				getFileName(strLine);
			}
		}
		
	}
	//��ȡ�ļ�������
	public void getFileName(String strLine){
		Matcher matcher = Pattern.compile("public class ([a-zA-Z]+)").matcher(strLine);
		if(matcher.find()){
			judgeMent = true;//�ҵ� ��
			keyName = matcher.group(1);//��ȡ�ļ���
		}
	}
	
}
