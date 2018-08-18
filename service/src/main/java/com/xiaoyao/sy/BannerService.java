package com.xiaoyao.sy;

import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileDao;
import com.xiaoyao.sys.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sys.Log;
import sys.ServiceException;

import java.util.List;

@Component
public class BannerService {

	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;

	public Banner findOne(String id){
		return bannerDao.findById(id).orElse(null);
	}

	public Page<Banner> findAll(Pageable pageable){
		return bannerDao.findAll(pageable);
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


	public List<Banner> listPage(int page,int type){
		Banner product =new Banner();
		product.setItype(type);
		Example<Banner> example=Example.of(product);

		return bannerDao.findAll(example);
	}


	public void delete(String id){
		try {
			bannerDao.deleteById(id);
		}catch (EmptyResultDataAccessException e){
			Log.info("id为"+id+"记录不存在",this.getClass());
			throw new ServiceException("记录不存在");
		}
	}





	public List<Banner> findTop4ByItype(Integer itype){
		return bannerDao.findTop4ByItype(itype);
	}


}
