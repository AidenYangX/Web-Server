package cn.com.cxsw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title    TestServlet.java
 * @describe  区别DoGet/DoPost
 * <p> @WebServlet 使用该注解实现底层XML中的注册和映射
 * <p> 3.0 以上版本的Servlet
 * e.g WebServlet(urlPatterns="/TestServlet")
 * @author   Rubin Zhang
 * @date	 2017年5月7日上午11:29:26
 */

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取请求方式
		System.out.println("获取请求方式："+request.getMethod());
		
		System.out.println("我是DoGet 方法");
		//2. *******设置编码类型为UTF-8(请求对象，响应对象)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//3.*****request.getContextPath() 获取项目根路径的方法
		//4.response.getWriter() 获取输出对象
		//response.getWriter().append("我是追加的值: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.write("<h1>我是输出对象输出的</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是DoPost 方法");
		doGet(request, response);
	}

}
