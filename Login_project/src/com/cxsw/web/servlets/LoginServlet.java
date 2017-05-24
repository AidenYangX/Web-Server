package com.cxsw.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cxsw.web.service.StudentsServiceImpl;

/**
 * @title LoginServlet.java
 * @describe 登录业务
 *           <p>
 *           处理用户的请求（request 请求对象），给予响应（response 响应对象）
 * @author Rubin Zhang
 * @date 2017年5月7日下午1:46:37
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码 -- set
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 2.获取用户的输入参数 -- get
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("userPass");
		System.out.println("测试用户输入的值：name> " + userName + " , pas > " + passWord);

		// Ⅰ，使用DbUtil 类
		/*
		 * ① 导入 jar (mysql 驱动包) ② 创建文件包 【com.cxsw.web.utils】 ③ 引入 DbUtil.java
		 */
		// 精确查询一条记录（userName,UserPass）

		// Ⅱ ，使用模型类
		StudentsServiceImpl studentService = new StudentsServiceImpl();

		// 3.判断得到结果(真实访问数据库)
		if (studentService.login(userName, passWord)) {
			// 4.存储用户的信息(Session )
			session.setAttribute("user", userName);
			// 5.给予响应(请求转发/重定向)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
