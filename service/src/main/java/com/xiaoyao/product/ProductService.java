package com.xiaoyao.product;

import com.xiaoyao.sp.Product;
import com.xiaoyao.sp.ProductDao;
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
public class ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;

	public Product findOne(String id){
		return productDao.findById(id).orElse(null);
	}

	public Page<Product> findAll(Pageable pageable){
		return productDao.findAll(pageable);
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


	public List<Product> listPage(int page,int type){
		Product product =new Product();
		product.setItype(type);
		Example<Product> example=Example.of(product);

		return productDao.findAll(example);
	}


	public void delete(String id){
		try {
			productDao.deleteById(id);
		}catch (EmptyResultDataAccessException e){
			Log.info("id为"+id+"记录不存在",this.getClass());
			throw new ServiceException("记录不存在");
		}
	}





	public List<Product> findProductForHome(Integer itype){
		return productDao.findTop6ByItype(itype);
	}


}
