package com.xiaoyao.sys;

import com.xiaoyao.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_operator")
public class Operator extends BaseEntity {


	@Column(nullable = false)
	private String soperatorname;

	@Column(nullable = false)
	private String spassword;




	public String getSoperatorname() {
		return soperatorname;
	}

	public void setSoperatorname(String soperatorname) {
		this.soperatorname = soperatorname;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

}
