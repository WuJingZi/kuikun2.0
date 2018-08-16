package com.xiaoyao.sys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 异常跳转配置器
 * @author XiaoYao
 *
 */
@Configuration
public class ExceptionConfiguration {
	@Bean
	public SimpleMappingExceptionResolver resolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties properties = new Properties();
		properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "sys/403");
		resolver.setExceptionMappings(properties);
		return resolver;
	}



}
