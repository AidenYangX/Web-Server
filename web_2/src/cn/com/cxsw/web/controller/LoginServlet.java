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
 * 		���ã������¼ҵ��
 *         <p>
 * 		1 �ʣ����ʵ��һ��Servlet? ģʽ���������߳�ģʽ
 *         <p>
 * 		�� �� ��ǰ������Ҫ�̳� HttpServlet ��
 *         <p>
 *         �� ʵ�������������� init();service();destroy(); (Servlet ��������)
 *         <p>
 *         �� ��Ҫȥ���õ�ǰ�ؼ���web.xml(web ������)
 *         <p>
 * 		2 �ʣ���δ���ҵ��
 *         <p>
 * 		�� �� ��ȡ���û������ֵ
 *         <p>
 *         �� ���û������ֵ�����жϣ�Mysql ���ݿ��з��ʲ�ѯ��
 *         <p>
 *         �� ���ݽ�����費ͬ����Ӧҳ��
 *         <p>
 * 		���ۣ���ǰ��Servlet ���յ�ҵ�񣺽����û�������request ������󣩣�������Ӧ��response ��Ӧ����
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * ��ʼ������
	 * 
	 * @Param ServletConfig config ���ö���
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init method ...");
	}

	/*
	 * ҵ������(����)
	 * 
	 * @Param HttpServletRequest arg0 �������, HttpServletResponse arg1 ��Ӧ����
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet service method ...");
		//  �ٻ�ȡ���û������ֵ
		//����ͨ���������ķ�����ȡǰ̨�û������ֵ
		//ע�� *******request.getParameter(String agrs��agrs ָ����form ���пؼ���Name ����ֵ
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println("���ԣ��û����� "+userName+" , ���롷 "+passWord);
		
		//  �� ���û������ֵ�����жϣ�Mysql ���ݿ��з��ʲ�ѯ--ģ�⣩
		if("admin".equals(userName)&& "root".equals(passWord)){
			// ��¼�ɹ���
			//  �� ���ݽ�����費ͬ����Ӧҳ��(******************����ת����ת***************)
			request.getRequestDispatcher("/index.html").forward(request, response);
		}else{
			//��¼ʧ����
			request.getRequestDispatcher("/fail.html").forward(request, response);
		}
		
	}

	/*
	 * ���ٷ���
	 */
	@Override
	public void destroy() {
		System.out.println("LoginServlet destroy method ...");
	}

}
