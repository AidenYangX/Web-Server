package com.cxsw.web.po;

/**
 * @title Student.java
 * @describe 模型层(类)
 *           <p>
 *           1.私有的属性    √
 *           <p>
 *           2.getter()/setter() √
 *           <p>
 *           3.有参构造器 （快速初始化）
 *           <p>
 *           4.无参构造器 （构建java类）
 *           <p>
 *           5.toString() （测试输出）
 *           <p>
 *           作用：方便存储数据和获取数据
 * @author Rubin Zhang
 * @date 2017年5月18日下午8:34:59
 */
public class Student {
	//student_info
	private Integer id;    // stu_id
	private String stuName; // stu_name
	private String stuSex;  
	private String stuAge;
	private String stuSchool;
	private String stuAddress;
	private String stuInfo;
	private String stuPhone;
	private String stuHobby;// 爱好
	// .....

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuAge() {
		return stuAge;
	}

	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuSchool() {
		return stuSchool;
	}

	public void setStuSchool(String stuSchool) {
		this.stuSchool = stuSchool;
	}

	public String getstuAddress() {
		return stuAddress;
	}

	public void setstuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(String stuInfo) {
		this.stuInfo = stuInfo;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuHobby() {
		return stuHobby;
	}

	public void setStuHobby(String stuHobby) {
		this.stuHobby = stuHobby;
	}

	public Student(Integer id, String stuName, String stuSex, String stuAge, String stuSchool, String stuAddress,
			String stuInfo, String stuPhone, String stuHobby) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuSchool = stuSchool;
		this.stuAddress = stuAddress;
		this.stuInfo = stuInfo;
		this.stuPhone = stuPhone;
		this.stuHobby = stuHobby;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuAge=" + stuAge
				+ ", stuSchool=" + stuSchool + ", stuAddress=" + stuAddress + ", stuInfo=" + stuInfo + ", stuPhone="
				+ stuPhone + ", stuHobby=" + stuHobby + "]";
	}

}
