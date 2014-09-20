package com.drdg.user.bean;

/**
 * SELECT TOP 1000 [user_id] ,[user_name] ,[user_password] ,[user_jur]
 * ,[user_contact] FROM [StudentCES].[dbo].[users]
 */

public class UserBean {

	private String user_id;
	private String user_name;
	private String user_password;
	private String user_jur;
	private String user_contact;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}

	public String getUser_jur() {
		return user_jur;
	}

	public void setUser_jur(String userJur) {
		user_jur = userJur;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String userContact) {
		user_contact = userContact;
	}

}
