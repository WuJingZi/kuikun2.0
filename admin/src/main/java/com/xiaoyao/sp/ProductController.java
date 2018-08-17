package com.xiaoyao.sp;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiaoyao.product.ProductService;
import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/product/")
public class ProductController {
	

	@Autowired
	private ProductService productService;
	@Autowired
	private FileService fileService;



	@RequestMapping("list")
	public String list ( Model model ,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "0") int type){
		List<Product> list=productService.listPage(page,type);

		model.addAttribute("page",list);
		model.addAttribute("type",type);

		return "sp/product-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "0") int type, Model model){
		Product product=productService.findOne(id);
		if(product==null) {
			product = new Product();
		}else{
			File file=fileService.findOneByBillid(product.getId());
			model.addAttribute("file",file);
		}
		model.addAttribute("product",product);
		model.addAttribute("type",type);
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


    @GetMapping("delete")
    public String delete (@RequestParam(defaultValue = "") String id, RedirectAttributes rmodel){
	    try {
            productService.delete(id);
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
