package cn.com.cxsw.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title InitParamServlet.java
 * @describe 有关Serlvet 初始化参数
 *           <p>
 *           ① 设置对象 ServletConfig 中获取的初始化参数为局部初始化参数
 *           <p>
 *           ② 程序域对象 ServletContext 中获取的初始化参数为全局初始化参数
 *           <p>
 *           问：初始化在哪里配置？
 *           <p>
 *           答：在Servlet 的注册配置中设置初始化参数
 *           <p>
 *           问：全局初始化如何配置？
 *           <p>
 *           答：在 web.xml 中配置全局初始化参数
 * @author Rubin Zhang
 * @date 2017年5月7日下午3:06:17
 */
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("当前servlet 的初始化参数：" + 
	config.getInitParameter("initParam"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
