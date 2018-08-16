package com.xiaoyao.sys;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,String> {


    Role findBySoperatorid(String soperatorname);
}
