package com.cxsw.img.service;

import com.cxsw.img.po.ImgModel;
import com.cxsw.img.utils.DbUtil;

/**
 * @title    ImgServiceImpl.java
 * @describe 接口实现类
 * <p>
 * @author   Rubin Zhang
 * @date	 2017年5月21日上午10:49:23
 */
public class ImgServiceImpl implements ImgService {
	private DbUtil db = null;
	private String sql ="";
	private int result = 0 ;

	@Override
	public boolean save(ImgModel im) {
		db = new DbUtil();
		sql = "INSERT INTO img_info (img_dec,img_name)VALUES(?,?)" ;
		//System.out.println("测试模型："+im);
		result = db.update(sql, im.getImgDec(),im.getImgName());
		//System.out.println("测试结果："+result);
		if(result > 0){
			return true;
		}
		return false;
	}

}
