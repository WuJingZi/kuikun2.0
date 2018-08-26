package com.xiaoyao.sp;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sp_product")
public class Product extends BaseEntity {


	@Column(nullable = false)
	private String sname;

	@Column(nullable = false)
	private Integer itype;

	@Column(nullable = false)
	private String simageurl;

	@Column(nullable = false)
	private String sprofiles;


	@Column(nullable = false)
	private Integer isshow;

	@Column(nullable = false)
	private String salt;


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSprofiles() {
		return sprofiles;
	}

	public void setSprofiles(String sprofiles) {
		this.sprofiles = sprofiles;
	}

	/**
	 * 10：办公楼厂房
	 * 20：商业装修
	 * 30：餐饮装修
	 * 40：酒店装修
	 * @return
	 */
	public Integer getItype() {
		return itype;
	}

	public Product setItype(Integer itype) {
		this.itype = itype;
		return this;
	}

	public String getSimageurl() {
		return simageurl;
	}

	public void setSimageurl(String simageurl) {
		this.simageurl = simageurl;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}