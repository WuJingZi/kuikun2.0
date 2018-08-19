package com.xiaoyao.sp;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sp_productinfo")
public class ProductInfo extends BaseEntity {


	@Column(nullable = false)
	private String sproductid;

	@Column(nullable = false)

	private String sname;

	@Column(nullable = false)
	private String simageurl;

	@Column(nullable = false)
	private Integer isort;




	public String getSproductid() {
		return sproductid;
	}

	public ProductInfo setSproductid(String sproductid) {
		this.sproductid = sproductid;
		return this;
	}

	public String getSimageurl() {
		return simageurl;
	}

	public void setSimageurl(String simageurl) {
		this.simageurl = simageurl;
	}

	public Integer getIsort() {
		return isort;
	}

	public void setIsort(Integer isort) {
		this.isort = isort;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}