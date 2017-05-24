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
