package com.xiaoyao.sy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@Controller
@RequestMapping("/ttk/")
public class TtkController {


	@Autowired
	private TtkService ttkService;



	@RequestMapping("list")
	public String list (Model model , @PageableDefault(value = 10,page = 0) Pageable pageable){
		Page<Ttk> list=ttkService.findAll(pageable);
		model.addAttribute("page",list);
		return "sy/ttk-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "10") int itype, Model model){
		Ttk ttk=ttkService.findOne(id);
		if(ttk==null) {
			ttk = new Ttk();
			ttk.setItype(itype);
		}
		model.addAttribute("ttk",ttk);
		return "sy/ttk-detail";
	}

	@PostMapping("save")
	@ResponseBody
	public Result save(@Valid Ttk ttk, BindingResult bindingResult, RedirectAttributes rmodel){
		try {
			ttkService.save(ttk);
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
			ttkService.delete(id);
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
