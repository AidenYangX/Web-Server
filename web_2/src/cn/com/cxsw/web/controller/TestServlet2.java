package cn.com.cxsw.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title    TestServlet2.java
 * @describe Servlet 配置中映射路径的设置
 * <p> ① 不是唯一不变的，并且一个 servlet 可以有多个映射路径
 * <p> ② 映射路径中的’/‘代表的是项目的根路径  e.g /web_2'/'
 * <p> ③ 映射路径一般使用非限定性类名（类名首字母小写）
 * 
 * @author   Rubin Zhang
 * @date	 2017年5月7日下午2:09:51
 */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是TestServlet2 的Get方法");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
