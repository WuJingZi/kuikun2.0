package com.xiaoyao.sys;

import java.util.List;

public interface FileDao extends BaseDao<File,String> {


    List<File> findBySbillid(String billid);
}
