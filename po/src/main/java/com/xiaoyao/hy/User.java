package com.xiaoyao.hy;

import com.xiaoyao.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hy_user")
public class User  extends BaseEntity{

	@Column(nullable = false)
	private String susername;
	@Column(nullable = false)
	private String spassword;
    
    
	public String getSusername() {
		return susername;
	}
	public void setSusername(String susername) {
		this.susername = susername;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	
}
