package cn.com.cxsw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @title    HttpMethodServlet.java
 * @describe 各个对象中的常用方法
 * <p>
 * @author   Rubin Zhang
 * @date	 2017年5月7日下午2:16:40
 */
@WebServlet("/httpMethodServlet")
public class HttpMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* HttpServletRequest request 请求对象，封装了请求的所有详细信息
	 * HttpServletResponse response 响应对象，封装了响应的所有信息
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.request 请求对象中常用方法
		// 设置 -- set相关的方法
		// 设置请求对象编码*****
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// **param1 :在请求域对象中设置的键值； **param2 :在请求域对象中键所对应的值；
		request.setAttribute("REQUEST", "REQUEST我是键所对应的值");
	
		// 获取 -- get 相关的方法
		System.out.println("获取请求参数***form 表单或者URL传值》》："+request.getParameter("scanParam"));
		System.out.println("获取项目根路径***》》："+request.getContextPath());
		System.out.println("获取请求URI***》》："+request.getRequestURI());
		System.out.println("获取请求域对象中的参数为REQUEST 的值***》》："+request.getAttribute("REQUEST"));
	
		System.out.println("获取本地服务器的端口号》》："+request.getLocalPort());
		System.out.println("获取请求方法》》："+request.getMethod());
		System.out.println("获取请求URL》》："+request.getRequestURL());
		
		//获取其他对象
		System.out.println("获取会话对象***》》："+request.getSession());
		//3.会话对象
		HttpSession session = request.getSession();
		session.setAttribute("SESSION", "SESSION我是键所对应的值");
		System.out.println("获取会话域对香中的参数为SESSION 的值***》》"+session.getAttribute("SESSION"));
		System.out.println("获取会话缓存的 id 标识:"+session.getId());
		
		System.out.println("获取应用程序上下文对象》》："+request.getServletContext());
		//4.应用程序上下文对象
		ServletContext application =  request.getServletContext();
		application.setAttribute("APPLICATION", "APPLICATION我是键所对应的值");
		System.out.println("获取程序域对象中的参数为APPLICATION 的值***》》"+application.getAttribute("APPLICATION"));
		System.out.println("获取初始化参数："+application.getInitParameter("initParam"));
		
		//2.response 响应对象 方法
		// set
		//设置响应页面中的编码格式（使用 OUT 输出页面时使用）
		//response.setContentType("text/html,chaset=utf-8");
		
		//get
		System.out.println("获取响应状态码》》"+response.getStatus());
		
		//****获取其他对象
		System.out.println("获取输出对象》》》"+response.getWriter());
		//输出对象
		PrintWriter out = response.getWriter();
		/*out.write("输出");
		out.println("输出");*/
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
