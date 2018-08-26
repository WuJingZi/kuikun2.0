package com.xiaoyao.index;

import com.xiaoyao.product.ProductInfoService;
import com.xiaoyao.product.ProductService;
import com.xiaoyao.sp.Product;
import com.xiaoyao.sp.ProductInfo;
import com.xiaoyao.sy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexAction {

	@Autowired
	private ProductService productService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private InterLinkService interLinkService;
	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private TtkService ttkService;


	@GetMapping("index")
	public String index(Model model){

		//banner
		List<Banner> banners=bannerService.findAllLimit(new Banner().setItype(10),4);

		//工程展示
		List<Banner> gongchengs=bannerService.findAllLimit(new Banner().setItype(20),4);
		model.addAttribute("banners",banners);
		model.addAttribute("gongchengs",gongchengs);

		//友情链接
		List<InterLink> interLinks=interLinkService.findByProperty(new InterLink(),20);
		model.addAttribute("interLinks",interLinks);

		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(10));
		model.addAttribute("ttk",ttk);
		return  "page/index";
	}


	@GetMapping("product")
	public String product(Model  model){
		List<Product> changfang= productService.findAllLimit(new Product().setItype(10),6);
		List<Product> shangye= productService.findAllLimit(new Product().setItype(20),6);
		List<Product> canyin= productService.findAllLimit(new Product().setItype(30),6);
		List<Product> jiudian= productService.findAllLimit(new Product().setItype(40),6);
		model.addAttribute("changfang",changfang);
		model.addAttribute("shangye",shangye);
		model.addAttribute("canyin",canyin);
		model.addAttribute("jiudian",jiudian);

		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(40));
		model.addAttribute("ttk",ttk);
		return  "page/product";
	}

	@GetMapping("product-view")
	public String productView(@RequestParam(defaultValue = "") String productid,Model model){
		List<ProductInfo> productInfos=productInfoService.findByProperties(new ProductInfo().setSproductid(productid),6);
		model.addAttribute("productInfos",productInfos);

		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(40));
		model.addAttribute("ttk",ttk);
		return  "page/product-view";
	}

	@GetMapping("serve")
	public String serve(Model model){

		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(30));
		model.addAttribute("ttk",ttk);
		return  "page/serve";
	}

	@GetMapping("idea")
	public String idea(Model model){
		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(50));
		model.addAttribute("ttk",ttk);
		return  "page/idea";
	}


	@GetMapping("about")
	public String about(Model model){

		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(20));
		model.addAttribute("ttk",ttk);
		return  "page/about";
	}

	@GetMapping("contact")
	public String contact(Model model){
		//TTK
		Ttk ttk=ttkService.findOne(new Ttk().setItype(60));
		model.addAttribute("ttk",ttk);
		return  "page/contact";
	}





}
