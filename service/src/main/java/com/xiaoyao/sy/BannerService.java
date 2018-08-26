package com.xiaoyao.sy;

import com.xiaoyao.sys.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sys.ServiceException;

@Service
@Transactional
public class BannerService extends BaseService<Banner>{

	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;


	@Override
	protected BaseDao<Banner, String> getBaseDao() {
		return bannerDao;
	}

	public void save(Banner vo, String fileid){
		if(vo.getItype()==20 && StringUtils.isBlank(vo.getSprofiles())){
			throw new ServiceException("简介不能为空");
		}else if(vo.getItype()==10){
			vo.setSprofiles("");  //banner 不需要简介
		}

		File file= fileService.findOne(fileid);
		if(file==null ||StringUtils.isBlank(file.getSurl())){
			throw new ServiceException("请先上传图片");
		}
		Banner product=new Banner();
		if(StringUtils.isNotBlank(vo.getId())){
			product=this.findOne(vo.getId());
		}

		product.setSprofiles(vo.getSprofiles());
		product.setItype(vo.getItype());
		product.setSimageurl(file.getSurl());
		product.setIsshow(vo.getIsshow()==null?1:vo.getIsshow());
		bannerDao.save(product);

		file.setSbillid(product.getId());

		fileDao.save(file);
	}


	@Override
	public void delete(String id) {
		fileService.deleteBybillid(id);
		super.delete(id);
	}
}
