package com.xiaoyao.sy;

import com.xiaoyao.sys.BaseDao;
import com.xiaoyao.sys.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sys.ServiceException;

@Service
@Transactional
public class TtkService extends BaseService<Ttk>{

	@Autowired
	private TtkDao ttkDao;


	@Override
	protected BaseDao<Ttk, String> getBaseDao() {
		return ttkDao;
	}

	public void save(Ttk vo){
		if(StringUtils.isBlank(vo.getSkeywords())){
			throw new ServiceException("关键词不能为空");
		}else if(vo.getSkeywords().trim().length()>100){
			throw new ServiceException("关键字长度不能大于100");
		}

		if(StringUtils.isBlank(vo.getSdescription())){
			throw new ServiceException("描述不能为空");
		}else if(vo.getSdescription().trim().length()>100){
			throw new ServiceException("描述长度不能大于100");
		}


		Ttk ttk=new Ttk();
		if(StringUtils.isNotBlank(vo.getId())){
			ttk=this.findOne(vo.getId());
		}
		ttk.setSkeywords(vo.getSkeywords());
		ttk.setSdescription(vo.getSdescription());
		ttkDao.save(ttk);

	}



}
