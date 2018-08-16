package com.xiaoyao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class AdminApplication {
	public static void main(String[] args) {
		try{
			SpringApplication.run(AdminApplication.class, args);
		}catch(Exception e){
			if(StringUtils.isNotBlank(e.getMessage())){
				System.out.println(e.getMessage());
			}
		}

	}
	
	
	

}
