package com.xiaoyao.sy;

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
@RequestMapping("/interlink/")
public class InterLinkController {


	@Autowired
	private InterLinkService interLinkService;



	@RequestMapping("list")
	public String list (Model model , @PageableDefault(value = 3,page = 0,sort = { "isort" }, direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(defaultValue = "0") int type){
		Page<InterLink> list=interLinkService.findAll(pageable);
		model.addAttribute("page",list);
		return "sy/interlink-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "0") int type, Model model){
		InterLink interLink=interLinkService.findOne(id);
		if(interLink==null) {
			interLink = new InterLink();
		}
		model.addAttribute("interLink",interLink);

		return "sy/interlink-detail";
	}

	@PostMapping("save")
	@ResponseBody
	public Result save(@Valid InterLink interLink, BindingResult bindingResult, RedirectAttributes rmodel){
		try {
			interLinkService.save(interLink);
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
		try {
			interLinkService.delete(id);
			Msg.success(rmodel,"删除成功");
		}catch (ServiceException e){
			e.printStackTrace();
			Msg.error(rmodel,e.getMessage());
		}catch (Exception e){
			Msg.error(rmodel,"删除失败");
			e.printStackTrace();
		}
		return "redirect:list";
	}









}
