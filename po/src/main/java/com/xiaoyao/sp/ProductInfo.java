package com.xiaoyao.sp;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sp_productinfo")
public class ProductInfo extends BaseEntity {


	@Column(nullable = false)
	private String sname;

	@Column(nullable = false)
	private String simageurl;

	@Column(nullable = false)
	private String sprofiles;



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

}