package com.cxsw.web.service;

import java.util.List;
import java.util.Map;

import com.cxsw.web.po.Student;

/**
 * @title StudentsService.java
 * @describe 业务接口类
 *           <p>
 *           作用：定义方法，确定参数类型
 * @author Rubin Zhang
 * @date 2017年5月18日下午8:02:04
 */
public interface StudentsService {

	/**
	 * 登录操作
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	boolean login(String userName, String userPass);

	/**
	 * 保存操作
	 * 
	 * @return
	 */
	boolean save(Student student);

	/**
	 * 修改操作
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	boolean update(int id);

	/**
	 * 删除一条记录
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	boolean deleteOneById(int id);

	/**
	 * 根据id 获取一条记录
	 * 
	 * @param id
	 *            唯一标识
	 * @return
	 */
	List<Map<String, Object>> getStudentById(int id);

	/**
	 * 根据id 获取一个对象
	 * 
	 * @param id
	 * @return
	 */
	Student getStudenOnetById(int id);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryAll();

	/**
	 * 模糊查询
	 * 
	 * @param scanParam
	 * @return
	 */
	List<Map<String, Object>> queryScanParam(String scanParam);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> pageQuery(int page);

	// 其他方法。。。。
}
