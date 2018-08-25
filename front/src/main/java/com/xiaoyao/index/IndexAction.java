package com.xiaoyao.index;

import com.xiaoyao.hy.UserService;
import com.xiaoyao.product.ProductInfoService;
import com.xiaoyao.product.ProductService;
import com.xiaoyao.sp.Product;
import com.xiaoyao.sp.ProductInfo;
import com.xiaoyao.sy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<Banner> banners=bannerService.findTop4ByItype(10);

		//工程展示
		List<Banner> gongchengs=bannerService.findTop4ByItype(20);
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
		List<Product> changfang= productService.findProductForHome(10);
		List<Product> shangye= productService.findProductForHome(20);
		List<Product> canyin= productService.findProductForHome(30);
		List<Product> jiudian= productService.findProductForHome(40);
		model.addAttribute("changfang",changfang);
		model.addAttribute("shangye",shangye);
		model.addAttribute("canyin",canyin);
		model.addAttribute("jiudian",jiudian);
		return  "page/product";
	}

	@GetMapping("product-view")
	public String productView(@RequestParam(defaultValue = "") String productid,Model model){
		List<ProductInfo> productInfos=productInfoService.findByProperties(new ProductInfo().setSproductid(productid),6);
		model.addAttribute("productInfos",productInfos);
		return  "page/product-view";
	}

	@GetMapping("serve")
	public String serve(){
		return  "page/serve";
	}

	@GetMapping("idea")
	public String idea(){
		return  "page/idea";
	}


	@GetMapping("about")
	public String about(){
		return  "page/about";
	}

	@GetMapping("contact")
	public String contact(){
		return  "page/contact";
	}





}
