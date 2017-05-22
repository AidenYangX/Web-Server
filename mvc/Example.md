### 1.M(model 模型层) Student.java 
作用：方便存储数据
1. 	需要有私有的属性，注：属性值和数据库中 student_info 表字段保持一致
2.  需要创建 Getter()&Setter()
3.  需要创建全参的构造器和无参的构造器
4.  toString() 方法的实现
		
 【com.cxsw.web.po.Student.java】:
```
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

```

### 2.M(Service 业务层) StudentService.java 
作用：当前 Student 对象对于数据的操作 CRUD(增查改删)
1.  需要声明全局的变量，方便在目标方法中赋值和使用
2.  在【com.cxsw.web.service.StudentsServiceImpl.java】中实现【com.cxsw.web.service.StudentsService.java】接口中的方法
3.  实现目标方法中的 CRUD(增查改删)业务
4.  返回数据库结果


 【com.cxsw.web.service.StudentService.java】:
 
```
package com.cxsw.web.service;

import java.util.List;
import java.util.Map;

import com.cxsw.web.po.Student;

/**
 * @title StudentsService.java
 * @describe 业务接口类
 *           <p>
 *           作用：定义方法，确定参数类型
 * @author Rubin Zhang
 * @date 2017年5月18日下午8:02:04
 */
public interface StudentsService {

	/**
	 * 登录操作
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	boolean login(String userName, String userPass);

	/**
	 * 保存操作
	 * 
	 * @return
	 */
	boolean save(Student student);

	/**
	 * 修改操作
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	boolean update(int id);

	/**
	 * 删除一条记录
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	boolean deleteOneById(int id);

	/**
	 * 根据id 获取一条记录
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	List<Map<String, Object>> getStudentById(int id);

	/**
	 * 根据id 获取一个对象
	 * 
	 * @param id
	 * @return
	 */
	Student getStudenOnetById(int id);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryAll();

	/**
	 * 模糊查询
	 * 
	 * @param scanParam
	 * @return
	 */
	List<Map<String, Object>> queryScanParam(String scanParam);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> pageQuery(int page);

	// 其他方法。。。。
}

```
【com.cxsw.web.service.StudentsServiceImpl.java】:

```
package com.cxsw.web.service;

import java.util.List;
import java.util.Map;

import com.cxsw.web.po.Student;
import com.cxsw.web.utils.DbUtil;

/**
 * @title StudentService.java
 * @describe 访问数据库，返回结果
 *           <p> 业务层
 *           <p>
 *           1，需要创建目标方法--什么业务
 * @author Rubin Zhang
 * @date 2017年5月18日下午7:52:42
 */
public class StudentsServiceImpl implements StudentsService {
	private DbUtil db = new DbUtil();
	private String sql = "";
	private int result = 0;
	private List<Map<String, Object>> data = null;

	/**
	 * 登录业务
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public boolean login(String userName, String userPass) {
		sql = "SELECT * FROM user_info WHERE user_name =? AND user_pas = ? AND state = '1'";
		result = db.query(sql, userName, userPass).size();
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 添加业务
	 */
	@Override
	public boolean save(Student stu) {
		sql = "INSERT INTO student_info (stu_name,stu_sex,stu_age,stu_school"
				+ ",stu_address,stu_info,stu_phone,stu_hobby,stu_img,stater)"
				+ " VALUES(?,?,?,?,?,?,?,?,'defult.png','1')";
		result = db.update(sql, stu.getStuName(),stu.getStuSex(),
				stu.getStuAge(),stu.getStuSchool(),
				stu.getstuAddress(),stu.getStuInfo(),
				stu.getStuPhone(),stu.getStuHobby());
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(int id) {
		sql = "UPDATE 表名 SET 字段名 = 占位符 WHERE id = ? ";
		result = db.update(sql, "参数", id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除
	 */
	@Override
	public boolean deleteOneById(int id) {
		sql = "DELETE FROM 表名  WHERE id = ? ";
		result = db.update(sql, id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getStudentById(int id) {
		sql = "SELECT * FROM 表名 WHERE id = ?";
		data = db.query(sql, id);
		return data;
	}

	@Override
	public Student getStudenOnetById(int id) {
		Student student = new Student();
		sql = "SELECT * FROM 表名 WHERE id = ?";
		//data = db.query(sql, id).get(0);
		return student;
	}

	@Override
	public List<Map<String, Object>> queryAll() {
		sql = "SELECT * FROM student_info GROUP BY stu_id DESC";
		data = db.query(sql);
		return data;
	}

	/**
	 * 模糊查询 -- 关键字 ？ LIKE '%scanParam%' 
	 */
	@Override
	public List<Map<String, Object>> queryScanParam(String scanParam) {
		sql = "SELECT * FROM 表名 WHERE 字段  LIKE '%scanParam%'";
		data = db.query(sql);
		return data;
	}

	@Override
	public List<Map<String, Object>> pageQuery(int page) {
		// TODO Auto-generated method stub
		return null;
	}
}

```




### 3.V(View 视图层) addStudent.jsp
作用：用户输入
1.  form 表单需用 post 请求
2.  input/select/textarea... 等表单控件中的 name 属性和模型对象 Student 属性名保持一致
3.  使用 submit 提交表单
4.  action 指定接受用户输入的 URL 地址("/AddStudentServlet")，注：需要获取项目的根路径
			
【/WebContent/mvc/addStudent.jsp】:

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">添加</a></li>
		</ul>
	</div>
	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<div>
			<form action="<%=request.getContextPath() %>/AddStudentServlet" method="post" class="forminfo">
				<label>STUDENTNAME</label>
				<br>
				<input type="text" name="stuName" class="scinput" placeholder="请正确输入名字" >
				<span id="stuNameMsg"></span>
				<br />
				<br />
				<label>STUDENTAGE</label>
				<br />
				<input type="text" name="stuAge" class="scinput" placeholder="请正确输入年龄">
				<span id="stuAgeMsg"></span>
				<br />
				<br />
				<label>STUDENTSEX：</label>
				<input type="radio" name="stuSex" value="男" checked="checked" >男
				<input type="radio" name="stuSex" value="女" >女
				<br />
				<br />
				<label>STUDENTHOBBY：</label>
				<input type="checkbox" name="stuHobby" id="" checked="checked" value="篮球">篮球
				<input type="checkbox" name="stuHobby" id="" value="足球">足球
				<input type="checkbox" name="stuHobby" id="" value="乒乓球">乒乓球
				<input type="checkbox" name="stuHobby" id="" value="保龄球">保龄球
				<input type="checkbox" name="stuHobby" id="" value="桌球">桌球
				<input type="checkbox" name="stuHobby" id="" value="桌球">桌球
				<br />
				<br />
				<label>STUDENTPHONE</label>
				<br />
				<input type="text" name="stuPhone" class="scinput" id="" placeholder="请正确输入手机号码">
				<span id="stuPhoneMsg"></span>
				<br />
				<label>STUDENTSCHOOL</label>
				<br />
				<select name="stuSchool" class="scinput" >
					<option value="-1">==请选择学校==</option>
					<option value="兰州交通大学">兰州交通大学</option>
					<option value="甘肃政法大学">甘肃政法大学</option>
					<option value="西北师范大学">西北师范大学</option>
					<option value="中国农业大学">中国农业大学</option>
				</select>
				<br />
				<br />
				<label>STUDENTADDRESS</label>
				<br />
				<input type="text" name="stuAddress" class="scinput" id="" placeholder="请正确输入详细地址">
				<span id="stuAddressMsg"></span>
				<br />
				<br />
				<label>USERDETAILS</label>
				<br />
				<textarea name="stuInfo" class="scinput" style="width:50%;height:100px;" placeholder="请输入基本信息" ></textarea>
				<br>
				<br>
				<input type="submit" class="btn" value="录入数据">
			</form>
		</div>
	</div>


</body>

</html>

```

		
### 4.C(Controller 控制层) AddStudentServlet.java
作用：获取用户的输入值给予响应

开发要求：
1.  需要注意变量的声明方法
2.  需要存储数据
3.  合理的声明对象
			
开发具体步骤：
1.  设置编码；
2.  获取用户的输入值，注：多值参数需要使用 request.getParamterValue();获取，该方法返回一个字符串数组，需要遍历，最终需要用字符串拼接的技术；
3.  将获取到的数据封装到 Student 模型对象中;
4.  调用 StudentsService 接口中的 save()方法，实现添加操作；
5.根据添加操作的返回结果给予不同的响应页面；
		
【com.cxsw.web.servlets.AddStudentServle.java】:

```
package com.cxsw.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.po.Student;
import com.cxsw.web.service.StudentsService;
import com.cxsw.web.service.StudentsServiceImpl;
import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;

/**
 * @title AddStudentServlet.java
 * @describe 处理添加的数据
 *           <p>
 * @author Rubin Zhang
 * @date 2017年5月18日下午8:29:42
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 2.获取参数
		String stuName = request.getParameter("stuName");
		String stuAge = request.getParameter("stuAge");
		String stuSex = request.getParameter("stuSex");
		String stuHobby = "";
		// 获取多值参数getParameterValues(attrbute);
		String[] hobbys = request.getParameterValues("stuHobby");
		for (String str : hobbys) {
			// System.out.println("测试值："+str);
			stuHobby += str + ",";
		}
		if (stuHobby != null) {
			stuHobby = stuHobby.substring(0, stuHobby.length() - 1);
		}
		String stuPhone = request.getParameter("stuPhone");
		String stuSchool = request.getParameter("stuSchool");
		String stuAddress = request.getParameter("stuAddress");
		String stuInfo = request.getParameter("stuInfo");
		System.out.println(
				"stuName:" + stuName + " , stuHobby:" + stuHobby + " ,stuSchool:" + stuSchool + " ,stuInfo:" + stuInfo);

		// 2-1 封装数据到模型中Student
		Student student = new Student(-1, stuName, stuSex, stuAge, stuSchool, stuAddress, stuInfo, stuPhone, stuHobby);

		// 3.调用StudentService.java 里的方法 save() ;
		StudentsService studentsService = new StudentsServiceImpl();
		// 4.返回结果 BOOLEAN TRUE 添加成功
		if (studentsService.save(student)) {
			// 添加成功
			// 5.TRUE 响应页面 （listStudent.jsp）
			response.sendRedirect(request.getContextPath() + "/mvc/listStudent.jsp");
			// request.getRequestDispatcher("/mvc/listStudent.jsp").forward(request,
			// response);
		} else {
			request.getRequestDispatcher("/mvc/addStudent.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

```
