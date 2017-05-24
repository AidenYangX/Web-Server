package com.cxsw.img.po;

/**
 * @title ImgModel.java
 * @describe 模型层
 *           <p>
 * @author Rubin Zhang
 * @date 2017年5月21日上午10:46:50
 */
public class ImgModel {
	private Integer id;
	private String imgDec;
	private String imgName;

	// .....
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgDec() {
		return imgDec;
	}

	public void setImgDec(String imgDec) {
		this.imgDec = imgDec;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public ImgModel(Integer id, String imgDec, String imgName) {
		super();
		this.id = id;
		this.imgDec = imgDec;
		this.imgName = imgName;
	}

	public ImgModel() {
		super();
	}

	@Override
	public String toString() {
		return "ImgModel [id=" + id + ", imgDec=" + imgDec + ", imgName=" + imgName + "]";
	}

}
