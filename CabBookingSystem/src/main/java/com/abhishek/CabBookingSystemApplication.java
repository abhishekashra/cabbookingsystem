package com.abhishek;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main file to load the Application
 * 
 * @author abhishek
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.abhishek")
@ConfigurationProperties(prefix = "datasource.cabbooking")
public class CabBookingSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingSystemApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CabBookingSystemApplication.class);
	}

	@Value("${datasource.cabbooking.url}")
	private String databaseUrl;

	@Value("${datasource.cabbooking.username}")
	private String username;

	@Value("${datasource.cabbooking.password}")
	private String pwd;

	@Value("${datasource.cabbooking.driverClassName}")
	private String driverClassName;

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClassName);
		dataSourceBuilder.url(databaseUrl);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(pwd);
		return dataSourceBuilder.build();
	}
}
