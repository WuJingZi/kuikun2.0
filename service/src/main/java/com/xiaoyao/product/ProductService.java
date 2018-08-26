package com.xiaoyao.product;

import com.xiaoyao.sp.Product;
import com.xiaoyao.sp.ProductDao;
import com.xiaoyao.sp.ProductInfo;
import com.xiaoyao.sp.ProductInfoDao;
import com.xiaoyao.sys.*;
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
public class ProductService extends BaseService<Product>{

	@Autowired
	private ProductDao productDao;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private ProductInfoDao productInfoDao;
	@Autowired
	private ProductInfoService productInfoService;


	@Override
	protected BaseDao<Product, String> getBaseDao() {
		return productDao;
	}

	public void save(Product vo, String fileid){
		if(StringUtils.isBlank(vo.getSname())){
			throw new ServiceException("名称不能为空");
		}
		if(StringUtils.isBlank(vo.getSprofiles())){
			throw new ServiceException("简介不能为空");
		}

		File file= fileService.findOne(fileid);
		if(file==null ||StringUtils.isBlank(file.getSurl())){
			throw new ServiceException("请先上传图片");
		}
		Product product=new Product();
		if(StringUtils.isNotBlank(vo.getId())){
			product=this.findOne(vo.getId());
		}

		product.setSname(vo.getSname());
		product.setSprofiles(vo.getSprofiles());
		product.setItype(vo.getItype());
		product.setSimageurl(file.getSurl());
		product.setIsshow(vo.getIsshow()==null?1:vo.getIsshow());
		productDao.save(product);

		file.setSbillid(product.getId());

		fileDao.save(file);
	}


	@Override
	public void delete(String id){
		try {
			productDao.deleteById(id);

			//删除文件

			//删除子表
			List<ProductInfo> productInfos= productInfoService.findByProperties(new ProductInfo().setSproductid(id));
			productInfoDao.deleteAll(productInfos);

		}catch (EmptyResultDataAccessException e){
			Log.info("id为"+id+"记录不存在",this.getClass());
			throw new ServiceException("记录不存在");
		}
	}







}
