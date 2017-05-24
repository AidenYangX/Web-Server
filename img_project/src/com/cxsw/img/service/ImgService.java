package com.cxsw.img.service;

import com.cxsw.img.po.ImgModel;

/**
 * @title ImgService.java
 * @describe 定义接口方法，确定参数类型及个数
 *           <p>
 * @author Rubin Zhang
 * @date 2017年5月21日上午10:48:23
 */
public interface ImgService {
	/**
	 * 图片保存方法
	 * 
	 * @param im
	 *            需要传入模型对象 ImgModel
	 * @return 返回Boolean ,若为True ,保存成功，若False ,保存失败
	 */
	boolean save(ImgModel im);
	// ......
}
