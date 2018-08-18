package com.xiaoyao.sy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BannerDao extends JpaRepository<Banner,String>,JpaSpecificationExecutor<Banner>{






}
