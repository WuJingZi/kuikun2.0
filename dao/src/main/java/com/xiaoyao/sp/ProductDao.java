package com.xiaoyao.sp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,String>,JpaSpecificationExecutor<Product>, PagingAndSortingRepository<Product,String> {




	List<Product> findTop6ByItype(Integer type);


}
