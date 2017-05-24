package com.cxsw.img.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cxsw.img.po.ImgModel;
import com.cxsw.img.service.ImgService;
import com.cxsw.img.service.ImgServiceImpl;
import com.cxsw.img.utils.HttpUtils;

/**
 * @title AddImgServlet.java
 * @describe �ļ��ϴ��Ŀ�����
 *           <p>
 *           ����1����λ�ȡ�ļ������
 *           <p>
 *           ��1��ͨ��request ���������� getPart("�ļ��ϴ������Name����ֵ");
 *           <p>
 *           ����2�����쳣 ��HTTP Status 500 - Unable to process parts as no multi-part
 *           configuration has been provided ��ǰservlet û��֧���ļ��ϴ�
 *           <p>
 *           ��2�������ļ��ϴ����ļ���ʹ��ע������ @MultipartConfig
 *           <p>
 *           ����3�����쳣��org.apache.tomcat.util.http.fileupload.FileUploadBase$InvalidContentTypeException:
 *           the request doesn't contain a multipart/form-data or
 *           multipart/mixed stream, content type header is
 *           application/x-www-form-urlencoded ����ͷ��û���ҵ��ļ��ϴ�������ֵ
 *           ��multipart/form-data or multipart/mixed stream
 *           <p>
 *           ��form ������Ҫ֧���ļ��ϴ�
 *           <p>
 *           ����4���ļ��洢�����
 *           <p>
 *           ��4���洢�ڵ�ǰ��Ŀ��ʱ�������η�����Ŀ��ͼƬ��������Դ���ᱻ���ǣ�
 *           Ϊ�˷�ֹ�ļ����ǣ�������Ҫ���ļ��洢����Ŀ�����ĸ�·���¡�tomcat/webapps�� e.g:
 *           G:\apache-tomcat-8.0.26\webapps\fileImgs
 *           <p>
 *           ����5����λ�ȡ����Ŀ�����ĸ�·����
 *           <p>
 *           ��5����Ҫ�� web.xml �����õ�ǰ��·��������ʹ��ȫ�ֵĳ�ʼ����������
 * 
 * @author Rubin Zhang
 * @date 2017��5��21������10:23:38
 */
@WebServlet("/AddImgServlet")
@MultipartConfig//֧���ļ��ϴ���ע������
public class AddImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 2.��ȡ����
		String imgDec = request.getParameter("imgDec");
		// �ļ��ϴ������
		Part part = request.getPart("fileName");
		// Ŀ���ļ��洢��ַ
		String parent = request.getServletContext().getInitParameter("filePath");
		System.out.println("����2��part �� " + part + " ,parent >" + parent);
		// �ϴ�����
		String fileNewName = HttpUtils.fileUpload(part, parent);
		// System.out.println("����1��imgDec> " + imgDec + " , fileNewName > " +
		// fileNewName);

		// 3.�洢��ģ����
		ImgModel im = new ImgModel(-1, imgDec, fileNewName);

		// 4.����ҵ���� save()
		ImgService ims = new ImgServiceImpl();

		// 5.��Ӧ
		if (ims.save(im)) {
			//
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
