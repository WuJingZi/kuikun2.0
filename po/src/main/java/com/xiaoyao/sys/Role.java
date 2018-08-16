package com.xiaoyao.sys;

import com.xiaoyao.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {


	@Column(nullable = false)
	private String soperatorid;

	@Column(nullable = false)
	private String srolename;


	public String getSoperatorid() {
		return soperatorid;
	}

	public void setSoperatorid(String soperatorid) {
		this.soperatorid = soperatorid;
	}

	public String getSrolename() {
		return srolename;
	}

	public void setSrolename(String srolename) {
		this.srolename = srolename;
	}
}
