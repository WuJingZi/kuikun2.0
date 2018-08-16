package com.xiaoyao.sys;

import http.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sys.ServiceException;

import java.util.Date;

@Component
public class FileService {
	
	@Autowired
	private FileDao fileDao;


	public File save(MultipartFile multipartFile){
		File file=new File();
		file.setSrealname(multipartFile.getOriginalFilename());
		file.setSname("");
		file.setSurl("");
		file.setSbillid("");
		file.setDadddate(new Date().toLocaleString());
		file= fileDao.save(file);

		file.setSname(new StringBuffer(file.getId()).append(".").append(multipartFile.getOriginalFilename().split("\\.")[1]).toString());
		String url=new String();
		try {
			url= FtpUtils.upload(multipartFile,file.getSname());
		}catch (Exception e){
			throw new ServiceException(e.getMessage());
		}
		file.setSurl(url);
		file= fileDao.save(file);
		return file;
	}

	public File findOne(String id) {
		 return fileDao.findById(id).orElse(null);
	}
}
