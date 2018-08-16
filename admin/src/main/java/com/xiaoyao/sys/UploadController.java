package com.xiaoyao.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sys.Result;
import sys.ServiceException;

@Controller
@RequestMapping("/upload/")
public class UploadController {
	

	@Autowired
    FileService fileService;

	@PostMapping("uploadimg")
	@ResponseBody
	public Result save(@RequestParam("file") MultipartFile multipartFile){
		try {
			File file =fileService.save(multipartFile);
			return Result.success(file);
		}catch (ServiceException e){
			return Result.failing(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			return Result.failing("保存失败");
		}

	}







	
	

}
