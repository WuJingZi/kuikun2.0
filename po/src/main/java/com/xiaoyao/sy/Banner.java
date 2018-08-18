package com.xiaoyao.sy;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sy_banner")
public class Banner extends BaseEntity {


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
	 * 10：banner
	 * 20：施工案例
	 * @return
	 */
	public Integer getItype() {
		return itype;
	}

	public void setItype(Integer itype) {
		this.itype = itype;
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
}