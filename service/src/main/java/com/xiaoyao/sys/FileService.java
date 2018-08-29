package com.xiaoyao.sys;

import http.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sys.ServiceException;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FileService extends BaseService<File>{
	
	@Autowired
	private FileDao fileDao;

	@Override
	protected BaseDao<File, String> getBaseDao() {
		return fileDao;
	}

	public File save(MultipartFile multipartFile){
		File file=new File();
		file.setSrealname(multipartFile.getOriginalFilename());
		file.setSname("");
		file.setSurl("");
		file.setSbillid("");
		file.setDadddate(new Date().toLocaleString());
		file.setSextension(new StringBuffer(".").append(multipartFile.getOriginalFilename().split("\\.")[1]).toString());
		file= fileDao.save(file);

		file.setSname(new StringBuffer(file.getId()).append(file.getSextension()).toString());
		String url=new String();
		try {
			url= FtpUtils.upload(multipartFile,file.getSname());
		}catch (Exception e){
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		file.setSurl(url);
		file= fileDao.save(file);
		return file;
	}


	public File findOneByBillid(String sbillid){
		List<File> files= fileDao.findBySbillid(sbillid);
		if(files.size()>0) {
			return files.get(0);
		}
		return null;
	}


	public void deleteBybillid(String billid){
		List<File> files=fileDao.findBySbillid(billid);
		files.forEach(file -> {
			//删除ftp上的文件
			FtpUtils.delete(file.getSname());
		});
		fileDao.deleteAll(files);
	}


}
