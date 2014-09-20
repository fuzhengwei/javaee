package com.junit;
import java.util.Locale;
import java.util.ResourceBundle;

public class JunitI18N {

	public static void main(String[] args) {
//		ResourceBundle res = ResourceBundle.getBundle("app", Locale.US);
//		System.out.println(res.getString("spotic_emp.emp_remarks" ));
		
		int pageNum = 20;
		int maxResult = 20;
		
		System.out.println(pageNum%maxResult);
	}
	
}
