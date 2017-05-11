package cn.com.cxsw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title    TestServlet.java
 * @describe  ����DoGet/DoPost
 * <p> @WebServlet ʹ�ø�ע��ʵ�ֵײ�XML�е�ע���ӳ��
 * <p> 3.0 ���ϰ汾��Servlet
 * e.g WebServlet(urlPatterns="/TestServlet")
 * @author   Rubin Zhang
 * @date	 2017��5��7������11:29:26
 */

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ȡ����ʽ
		System.out.println("��ȡ����ʽ��"+request.getMethod());
		
		System.out.println("����DoGet ����");
		//2. *******���ñ�������ΪUTF-8(���������Ӧ����)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//3.*****request.getContextPath() ��ȡ��Ŀ��·���ķ���
		//4.response.getWriter() ��ȡ�������
		//response.getWriter().append("����׷�ӵ�ֵ: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.write("<h1>����������������</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����DoPost ����");
		doGet(request, response);
	}

}
