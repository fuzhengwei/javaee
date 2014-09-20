package com.dhls.factory.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dhls.factory.ReadFile;
import com.dhls.factory.RegexGetCode;

public class ReadTxt implements ReadFile {

	//ͨ�����ʵ����
	RegexGetCode regexGetCode;
	CodeCombination codeCombination = new CodeCombination();
	String strLine = null;
	public ReadTxt(RegexGetCode regexGetCode){
		this.regexGetCode = regexGetCode;
	}
	
	@Override
	public void doReadFile(String url) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader( new FileInputStream(url)));
			//String strLine = null;
			while((strLine = br.readLine()) != null){
				//������صĴ���
//				System.out.println(regexGetCode.getCode(strLine));
			
				//����
				filterCode(regexGetCode.getCode(strLine));
				//д��
				codeCombination.doCodeCom(regexGetCode.getCode(strLine));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(null != br){
					br.close();
					br = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
