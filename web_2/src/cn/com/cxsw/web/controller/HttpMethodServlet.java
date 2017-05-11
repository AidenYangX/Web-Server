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
 * @describe ���������еĳ��÷���
 * <p>
 * @author   Rubin Zhang
 * @date	 2017��5��7������2:16:40
 */
@WebServlet("/httpMethodServlet")
public class HttpMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* HttpServletRequest request ������󣬷�װ�������������ϸ��Ϣ
	 * HttpServletResponse response ��Ӧ���󣬷�װ����Ӧ��������Ϣ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.request ��������г��÷���
		// ���� -- set��صķ���
		// ��������������*****
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// **param1 :����������������õļ�ֵ�� **param2 :������������м�����Ӧ��ֵ��
		request.setAttribute("REQUEST", "REQUEST���Ǽ�����Ӧ��ֵ");
	
		// ��ȡ -- get ��صķ���
		System.out.println("��ȡ�������***form ������URL��ֵ������"+request.getParameter("scanParam"));
		System.out.println("��ȡ��Ŀ��·��***������"+request.getContextPath());
		System.out.println("��ȡ����URI***������"+request.getRequestURI());
		System.out.println("��ȡ����������еĲ���ΪREQUEST ��ֵ***������"+request.getAttribute("REQUEST"));
	
		System.out.println("��ȡ���ط������Ķ˿ںš�����"+request.getLocalPort());
		System.out.println("��ȡ���󷽷�������"+request.getMethod());
		System.out.println("��ȡ����URL������"+request.getRequestURL());
		
		//��ȡ��������
		System.out.println("��ȡ�Ự����***������"+request.getSession());
		//3.�Ự����
		HttpSession session = request.getSession();
		session.setAttribute("SESSION", "SESSION���Ǽ�����Ӧ��ֵ");
		System.out.println("��ȡ�Ự������еĲ���ΪSESSION ��ֵ***����"+session.getAttribute("SESSION"));
		System.out.println("��ȡ�Ự����� id ��ʶ:"+session.getId());
		
		System.out.println("��ȡӦ�ó��������Ķ��󡷡���"+request.getServletContext());
		//4.Ӧ�ó��������Ķ���
		ServletContext application =  request.getServletContext();
		application.setAttribute("APPLICATION", "APPLICATION���Ǽ�����Ӧ��ֵ");
		System.out.println("��ȡ����������еĲ���ΪAPPLICATION ��ֵ***����"+application.getAttribute("APPLICATION"));
		System.out.println("��ȡ��ʼ��������"+application.getInitParameter("initParam"));
		
		//2.response ��Ӧ���� ����
		// set
		//������Ӧҳ���еı����ʽ��ʹ�� OUT ���ҳ��ʱʹ�ã�
		//response.setContentType("text/html,chaset=utf-8");
		
		//get
		System.out.println("��ȡ��Ӧ״̬�롷��"+response.getStatus());
		
		//****��ȡ��������
		System.out.println("��ȡ������󡷡���"+response.getWriter());
		//�������
		PrintWriter out = response.getWriter();
		/*out.write("���");
		out.println("���");*/
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
