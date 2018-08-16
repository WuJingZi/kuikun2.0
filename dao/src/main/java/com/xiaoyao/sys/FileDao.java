package com.xiaoyao.sys;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileDao extends JpaRepository<File,String> {


    List<File> findBySbillid(String billid);
}
