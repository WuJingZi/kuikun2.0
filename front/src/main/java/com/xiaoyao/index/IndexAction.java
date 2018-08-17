package com.xiaoyao.index;

import com.xiaoyao.hy.UserService;
import com.xiaoyao.product.ProductService;
import com.xiaoyao.sp.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexAction {

	@Autowired
	private ProductService productService;


	@GetMapping("index")
	public String index(){
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
