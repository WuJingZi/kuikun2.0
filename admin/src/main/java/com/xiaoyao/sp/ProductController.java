package com.xiaoyao.sp;

import com.xiaoyao.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sys.Result;
import sys.ServiceException;

import javax.validation.Valid;

@Controller
@RequestMapping("/product/")
public class ProductController {
	

	@Autowired
	private ProductService productService;



	@RequestMapping("list")
	public String list ( Model model ,@RequestParam(defaultValue = "0") int page){
		Page<Product> list=productService.listPage(page);

		model.addAttribute("page",list);
		return "sp/product-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id, Model model){
		Product product=productService.findOne(id);
		if(product==null)
			product=new Product();
		model.addAttribute("product",product);
		return "sp/product-detail";
	}

	@PostMapping("save")
	@ResponseBody
	public Result save(@Valid Product product, @RequestParam(defaultValue = "")String sfileid, BindingResult bindingResult, RedirectAttributes rmodel){
		try {
			productService.save(product,sfileid);
			return Result.success(rmodel,"保存成功");
		}catch (ServiceException e){
			return Result.failing(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			return Result.failing("保存失败");
		}

	}







	
	

}
