package com.xiaoyao.product;

import com.xiaoyao.sp.Product;
import com.xiaoyao.sp.ProductDao;
import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileDao;
import com.xiaoyao.sys.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import sys.ServiceException;

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
		if(StringUtils.isBlank(vo.getSprovince())){
			throw new ServiceException("省份不能为空");
		}
		if(StringUtils.isBlank(vo.getScity())){
			throw new ServiceException("城市不能为空");
		}
		if(StringUtils.isBlank(vo.getSaddress())){
			throw new ServiceException("详细地址不能为空");
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
		product.setScity(vo.getScity());
		product.setSprovince(vo.getSprovince());
		product.setSaddress(vo.getSaddress());
		product.setItype(vo.getItype());
		product.setSimageurl(file.getSurl());
		product.setIsshow(vo.getIsshow()==null?1:vo.getIsshow());
		productDao.save(product);

		file.setSbillid(product.getId());

		fileDao.save(file);
	}


	public Page<Product> listPage(int page){
		return productDao.findAll( PageRequest.of(0, 2, Sort.by(Sort.Order.desc("sname"))));
	}






}
