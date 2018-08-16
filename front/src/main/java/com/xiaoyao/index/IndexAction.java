package com.xiaoyao.index;

import com.xiaoyao.hy.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {




	@GetMapping("index")
	public String index(){
		return  "page/index";
	}


	@GetMapping("product")
	public String product(){
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
