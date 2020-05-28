package cova.fss.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan(basePackages = {"cova.rar.service", "cova.rar.dao", "cova.rar.controller",
		"org.springframework.jdbc.datasource.DriverManagerDataSource",
		"org.springframework.jdbc.core.JdbcTemplate"})
public class BeanConfig {
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost/rentarig?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		dmds.setSchema("rentarig");
		return dmds;
	}
	
	@Bean 
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	

}
