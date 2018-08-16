package com.xiaoyao.sp;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDao extends JpaSpecificationExecutor<Product>, PagingAndSortingRepository<Product,String> {



}
