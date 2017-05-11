package cn.com.cxsw.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rubin Zhang
 *         <p>
 * 		作用：处理登录业务
 *         <p>
 * 		1 问：如何实现一个Servlet? 模式：单例多线程模式
 *         <p>
 * 		答： ① 当前的类需要继承 HttpServlet 类
 *         <p>
 *         ② 实现以下三个方法 init();service();destroy(); (Servlet 生命周期)
 *         <p>
 *         ③ 需要去配置当前控件到web.xml(web 容器中)
 *         <p>
 * 		2 问：如何处理业务？
 *         <p>
 * 		答： ① 获取到用户输入的值
 *         <p>
 *         ② 对用户输入的值进行判断（Mysql 数据库中访问查询）
 *         <p>
 *         ③ 根据结果给予不同的响应页面
 *         <p>
 * 		结论：当前的Servlet 最终的业务：接受用户的请求（request 请求对象），给予响应（response 响应对象）
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * 初始化方法
	 * 
	 * @Param ServletConfig config 配置对象
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init method ...");
	}

	/*
	 * 业务处理方法(服务)
	 * 
	 * @Param HttpServletRequest arg0 请求对象, HttpServletResponse arg1 响应对象
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet service method ...");
		//  ①获取到用户输入的值
		//可以通过请求对象的方法获取前台用户输入的值
		//注： *******request.getParameter(String agrs）agrs 指的是form 表单中控件的Name 属性值
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println("测试：用户名》 "+userName+" , 密码》 "+passWord);
		
		//  ② 对用户输入的值进行判断（Mysql 数据库中访问查询--模拟）
		if("admin".equals(userName)&& "root".equals(passWord)){
			// 登录成功了
			//  ③ 根据结果给予不同的响应页面(******************请求转发跳转***************)
			request.getRequestDispatcher("/index.html").forward(request, response);
		}else{
			//登录失败了
			request.getRequestDispatcher("/fail.html").forward(request, response);
		}
		
	}

	/*
	 * 销毁方法
	 */
	@Override
	public void destroy() {
		System.out.println("LoginServlet destroy method ...");
	}

}
