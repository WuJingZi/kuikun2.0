package com.xiaoyao.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;



	public Role findBySoperatorid(String opratorid){

		return roleDao.findBySoperatorid(opratorid);
	}
}
