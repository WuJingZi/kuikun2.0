package com.xiaoyao.sp;

import com.xiaoyao.product.ProductInfoService;
import com.xiaoyao.product.ProductService;
import com.xiaoyao.sys.File;
import com.xiaoyao.sys.FileService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/productinfo/")
public class ProductInfoController {
	

	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private FileService fileService;



	@RequestMapping("list")
	public String list ( Model model ,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String productid){
		List<ProductInfo> list=productInfoService.findByProperties(new ProductInfo().setSproductid(productid),6);
		model.addAttribute("sproductid",productid);
		model.addAttribute("page",list);

		return "sp/productinfo-list";
	}

	@GetMapping("detail")
	public String detail (@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "") String sproductid, Model model){
		ProductInfo productInfo=productInfoService.findOne(id);
		if(productInfo==null) {
			productInfo = new ProductInfo();
			productInfo.setSproductid(sproductid);
		}else{
			File file=fileService.findOneByBillid(productInfo.getId());
			model.addAttribute("file",file);
		}
		model.addAttribute("obj",productInfo);
		return "sp/productinfo-detail";
	}

	@PostMapping("save")
	@ResponseBody
	public Result save(@Valid ProductInfo productInfo, @RequestParam(defaultValue = "")String sfileid, BindingResult bindingResult, RedirectAttributes rmodel){
		try {
			productInfoService.save(productInfo,sfileid);
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
            productInfoService.delete(id);
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
