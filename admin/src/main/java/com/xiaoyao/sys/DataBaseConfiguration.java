package com.xiaoyao.sys;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;
import sys.Log;

import javax.sql.DataSource;
import java.net.URL;

@Configuration
public class DataBaseConfiguration {


	@Bean(destroyMethod = "", name = "EmbeddeddataSource")
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.sqlite.JDBC");
		String dbUrl=new StringBuffer("jdbc:sqlite:").append(System.getProperty("user.dir")).append("/kuikun.db").toString();
		Log.info(dbUrl,this.getClass());
		dataSourceBuilder.url(dbUrl);
		dataSourceBuilder.type(SQLiteDataSource.class);
		return dataSourceBuilder.build();

	}
}
