package com.xiaoyao.sys;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDao extends JpaRepository<File,String> {


    File findBySbillid(String billid);
}
