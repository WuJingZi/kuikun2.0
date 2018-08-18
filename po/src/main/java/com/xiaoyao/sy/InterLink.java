package com.xiaoyao.sy;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sy_interlink")
public class InterLink extends BaseEntity {


	@Column(nullable = false)
	private String sname;

	@Column(nullable = false)
	private String surl;

	@Column(nullable = false)
	private Integer isort;


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public Integer getIsort() {
		return isort;
	}

	public void setIsort(Integer isort) {
		this.isort = isort;
	}
}