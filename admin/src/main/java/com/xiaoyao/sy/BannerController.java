package com.xiaoyao.sy;

import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sys.Msg;
import sys.Result;
import sys.ServiceException;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/banner/")
public class BannerController {


	@Autowired
	private BannerService bannerService;
	@Autowired
	private FileService fileService;



	@RequestMapping("list")
	public String list (Model model , @PageableDefault(value = 10,page = 0) Pageable pageable,@RequestParam(defaultValue = "0") int type){
		Page<Banner> list=bannerService.findAll(new Banner().setItype(type),pageable);

		model.addAttribute("page",list);
		model.addAttribute("type",type);
		if(type==10){

			return "sy/banner-list";
		}
		return "sy/gongcheng-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "0") int type, Model model){
		Banner banner=bannerService.findOne(id);
		if(banner==null) {
			banner = new Banner();
		}else{
			File file=fileService.findOneByBillid(banner.getId());
			model.addAttribute("file",file);
		}
		model.addAttribute("banner",banner);
		if(type==10) {
			return "sy/banner-detail";
		}else{
			return "sy/gongcheng-detail";
		}
	}

	@PostMapping("save")
	@ResponseBody
	public Result save(@Valid Banner banner, @RequestParam(defaultValue = "")String sfileid, BindingResult bindingResult, RedirectAttributes rmodel){
		try {
			bannerService.save(banner,sfileid);
			return Result.success(rmodel,"保存成功");
		}catch (ServiceException e){
			return Result.failing(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			return Result.failing("保存失败");
		}

	}


	@GetMapping("delete")
	public String delete (@RequestParam(defaultValue = "") String id, RedirectAttributes rmodel){
		Banner banner=bannerService.findOne(id);
		try {
			bannerService.delete(id);
			Msg.success(rmodel,"删除成功");
		}catch (ServiceException e){
			e.printStackTrace();
			Msg.error(rmodel,e.getMessage());
		}catch (Exception e){
			Msg.error(rmodel,"删除失败");
			e.printStackTrace();
		}
		rmodel.addAttribute("type",banner.getItype());
		return "redirect:list";
	}









}
