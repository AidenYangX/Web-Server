package cn.com.cxsw.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title    TestServlet2.java
 * @describe Servlet ������ӳ��·��������
 * <p> �� ����Ψһ����ģ�����һ�� servlet �����ж��ӳ��·��
 * <p> �� ӳ��·���еġ�/�����������Ŀ�ĸ�·��  e.g /web_2'/'
 * <p> �� ӳ��·��һ��ʹ�÷��޶�����������������ĸСд��
 * 
 * @author   Rubin Zhang
 * @date	 2017��5��7������2:09:51
 */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����TestServlet2 ��Get����");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
