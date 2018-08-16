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
	private String sprovince;

	@Column(nullable = false)
	private String scity;

	@Column(nullable = true)
	private String saddress;

	@Column(nullable = false)
	private Integer isshow;


	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

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

	public String getSprovince() {
		return sprovince;
	}

	public void setSprovince(String sprovince) {
		this.sprovince = sprovince;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
}