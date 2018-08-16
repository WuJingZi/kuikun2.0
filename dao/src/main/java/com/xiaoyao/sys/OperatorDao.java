package com.xiaoyao.sys;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorDao  extends JpaRepository<Operator,String> {


    Operator findBySoperatorname(String soperatorname);
}
