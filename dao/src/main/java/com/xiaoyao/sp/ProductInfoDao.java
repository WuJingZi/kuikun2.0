package com.xiaoyao.sp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String>,JpaSpecificationExecutor<ProductInfo>{






}
