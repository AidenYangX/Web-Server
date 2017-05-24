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
 * @describe 文件上传的控制器
 *           <p>
 *           问题1：如何获取文件域对象
 *           <p>
 *           答1：通过request 请求域对象的 getPart("文件上传对象的Name属性值");
 *           <p>
 *           问题2：报异常 ：HTTP Status 500 - Unable to process parts as no multi-part
 *           configuration has been provided 当前servlet 没有支持文件上传
 *           <p>
 *           答2：配置文件上传的文件，使用注解配置 @MultipartConfig
 *           <p>
 *           问题3：报异常：org.apache.tomcat.util.http.fileupload.FileUploadBase$InvalidContentTypeException:
 *           the request doesn't contain a multipart/form-data or
 *           multipart/mixed stream, content type header is
 *           application/x-www-form-urlencoded 请求头中没有找到文件上传的类型值
 *           ：multipart/form-data or multipart/mixed stream
 *           <p>
 *           答：form 表单中需要支持文件上传
 *           <p>
 *           问题4：文件存储在哪里？
 *           <p>
 *           答4：存储在当前项目中时，如果多次发布项目，图片等其他资源将会被覆盖，
 *           为了防止文件覆盖，我们需要把文件存储在项目发布的根路径下【tomcat/webapps】 e.g:
 *           G:\apache-tomcat-8.0.26\webapps\fileImgs
 *           <p>
 *           问题5：如何获取到项目发布的根路径？
 *           <p>
 *           答5：需要在 web.xml 中配置当前的路径，须有使用全局的初始化参数配置
 * 
 * @author Rubin Zhang
 * @date 2017年5月21日上午10:23:38
 */
@WebServlet("/AddImgServlet")
@MultipartConfig//支持文件上传的注解配置
public class AddImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 2.获取参数
		String imgDec = request.getParameter("imgDec");
		// 文件上传域对象
		Part part = request.getPart("fileName");
		// 目标文件存储地址
		String parent = request.getServletContext().getInitParameter("filePath");
		System.out.println("测试2：part 》 " + part + " ,parent >" + parent);
		// 上传操作
		String fileNewName = HttpUtils.fileUpload(part, parent);
		// System.out.println("测试1：imgDec> " + imgDec + " , fileNewName > " +
		// fileNewName);

		// 3.存储到模型中
		ImgModel im = new ImgModel(-1, imgDec, fileNewName);

		// 4.调用业务层的 save()
		ImgService ims = new ImgServiceImpl();

		// 5.响应
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
