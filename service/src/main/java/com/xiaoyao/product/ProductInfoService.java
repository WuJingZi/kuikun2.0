package com.xiaoyao.product;

import com.xiaoyao.sp.ProductInfo;
import com.xiaoyao.sp.ProductInfoDao;
import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileDao;
import com.xiaoyao.sys.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sys.Log;
import sys.ServiceException;

import java.util.List;

@Component
public class ProductInfoService {

	@Autowired
	private ProductInfoDao productInfoDao;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;

	public ProductInfo findOne(String id){
		return productInfoDao.findById(id).orElse(null);
	}

	public Page<ProductInfo> findAll(Pageable pageable){
		return productInfoDao.findAll(pageable);
	}

	public void save(ProductInfo vo, String fileid){
		if(StringUtils.isBlank(vo.getSname())){
			throw new ServiceException("名称不能为空");
		}

		File file= fileService.findOne(fileid);
		if(file==null ||StringUtils.isBlank(file.getSurl())){
			throw new ServiceException("请先上传图片");
		}
		ProductInfo productInfo=new ProductInfo();
		if(StringUtils.isNotBlank(vo.getId())){
			productInfo=this.findOne(vo.getId());
		}

		if(StringUtils.isBlank(vo.getSproductid())){
			throw new ServiceException("productid不能为空");
		}

		productInfo.setSproductid(vo.getSproductid());
		productInfo.setSname(vo.getSname());
		productInfo.setSimageurl(file.getSurl());
		productInfo.setIsort(0);
		productInfoDao.save(productInfo);

		file.setSbillid(productInfo.getId());

		fileDao.save(file);
	}



	public void delete(String id){
		try {
			productInfoDao.deleteById(id);
		}catch (EmptyResultDataAccessException e){
			Log.info("id为"+id+"记录不存在",this.getClass());
			throw new ServiceException("记录不存在");
		}
	}


	public List<ProductInfo> findByProperties(ProductInfo vo,int limit){
		Example<ProductInfo> example=Example.of(vo);
		return productInfoDao.findAll(example, PageRequest.of(0,limit)).getContent();
	}







}
