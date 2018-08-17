package com.xiaoyao.sp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDao extends JpaRepository<Product,String>,JpaSpecificationExecutor<Product>, PagingAndSortingRepository<Product,String> {



}
