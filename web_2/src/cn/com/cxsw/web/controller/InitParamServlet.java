package cn.com.cxsw.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title InitParamServlet.java
 * @describe �й�Serlvet ��ʼ������
 *           <p>
 *           �� ���ö��� ServletConfig �л�ȡ�ĳ�ʼ������Ϊ�ֲ���ʼ������
 *           <p>
 *           �� ��������� ServletContext �л�ȡ�ĳ�ʼ������Ϊȫ�ֳ�ʼ������
 *           <p>
 *           �ʣ���ʼ�����������ã�
 *           <p>
 *           ����Servlet ��ע�����������ó�ʼ������
 *           <p>
 *           �ʣ�ȫ�ֳ�ʼ��������ã�
 *           <p>
 *           ���� web.xml ������ȫ�ֳ�ʼ������
 * @author Rubin Zhang
 * @date 2017��5��7������3:06:17
 */
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ǰservlet �ĳ�ʼ��������" + 
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
