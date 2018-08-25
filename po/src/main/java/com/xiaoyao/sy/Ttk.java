package com.xiaoyao.sy;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sy_ttk")
public class Ttk extends BaseEntity {



	@Column(nullable = false)
	private Integer itype;

	@Column(nullable = false)
	private String sdescription;

	@Column(nullable = false)
	private String skeywords;

	/**
	 * 10：首页
	 * 20：关于逵坤
	 * 30：服务领域
	 * 40：工程案例
	 * 50：逵坤理念
	 * 60：联系我们
	 * @return
	 */
	public Integer getItype() {
		return itype;
	}

	public Ttk setItype(Integer itype) {
		this.itype = itype;
		return this;
	}

	public String getSdescription() {
		return sdescription;
	}

	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}

	public String getSkeywords() {
		return skeywords;
	}

	public void setSkeywords(String skeywords) {
		this.skeywords = skeywords;
	}


}