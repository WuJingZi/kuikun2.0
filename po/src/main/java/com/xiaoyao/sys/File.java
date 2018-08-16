package com.xiaoyao.sys;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_file")
public class File extends BaseEntity {


	@Column(nullable = false)
	private String sname;

	@Column(nullable = false)
	private String sbillid;

	@Column(nullable = false)
	private String srealname;

	@Column(nullable = false)
	private String surl;

	@Column(nullable = false)
	private String dadddate;


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSrealname() {
		return srealname;
	}

	public void setSrealname(String srealname) {
		this.srealname = srealname;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getSbillid() {
		return sbillid;
	}

	public void setSbillid(String sbillid) {
		this.sbillid = sbillid;
	}

	public String getDadddate() {
		return dadddate;
	}

	public void setDadddate(String dadddate) {
		this.dadddate = dadddate;
	}
}
