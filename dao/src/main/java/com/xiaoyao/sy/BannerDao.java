package com.xiaoyao.sy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BannerDao extends JpaRepository<Banner,String>,JpaSpecificationExecutor<Banner>{


	List<Banner> findTop4ByItype(Integer itype);



}
