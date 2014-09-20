package com.drdg.student.bean;

/*
 * SELECT TOP 1000 [stu_id]
 ,[stu_name]
 ,[stu_sex]
 ,[stu_birthday]
 ,[stu_nation]
 ,[stu_pa]
 ,[stu_pro_number]
 ,[stu_class_number]
 ,[stu_bedroom_number]
 ,[stu_contact]
 ,[stu_pwd]
 FROM [StudentCES].[dbo].[student]
 学号	性别	年龄	生日	民族	政治面貌	学生专业编号	学生班级编号	学生寝室编号	联系方式  密码
 */
public class StudentBean {

	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private String stu_birthday;
	private String stu_nation;
	private String stu_pa;
	private String stu_pro_number;
	private String stu_class_number;
	private String stu_bedroom_number;
	private String stu_contact;
	private String stu_pwd;
	
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stuId) {
		stu_id = stuId;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stuSex) {
		stu_sex = stuSex;
	}

	public String getStu_birthday() {
		return stu_birthday;
	}

	public void setStu_birthday(String stuBirthday) {
		stu_birthday = stuBirthday;
	}

	public String getStu_nation() {
		return stu_nation;
	}

	public void setStu_nation(String stuNation) {
		stu_nation = stuNation;
	}

	public String getStu_pa() {
		return stu_pa;
	}

	public void setStu_pa(String stuPa) {
		stu_pa = stuPa;
	}

	public String getStu_pro_number() {
		return stu_pro_number;
	}

	public void setStu_pro_number(String stuProNumber) {
		stu_pro_number = stuProNumber;
	}

	public String getStu_class_number() {
		return stu_class_number;
	}

	public void setStu_class_number(String stuClassNumber) {
		stu_class_number = stuClassNumber;
	}

	public String getStu_bedroom_number() {
		return stu_bedroom_number;
	}

	public void setStu_bedroom_number(String stuBedroomNumber) {
		stu_bedroom_number = stuBedroomNumber;
	}

	public String getStu_contact() {
		return stu_contact;
	}

	public void setStu_contact(String stuContact) {
		stu_contact = stuContact;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	public String getStu_pwd() {
		return stu_pwd;
	}

	public void setStu_pwd(String stuPwd) {
		stu_pwd = stuPwd;
	}

}
