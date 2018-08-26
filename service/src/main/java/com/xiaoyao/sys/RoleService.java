package com.xiaoyao.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;



	public Role findBySoperatorid(String opratorid){

		return roleDao.findBySoperatorid(opratorid);
	}
}
