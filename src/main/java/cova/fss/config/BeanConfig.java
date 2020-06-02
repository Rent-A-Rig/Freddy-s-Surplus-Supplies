package cova.fss.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import cova.fss.dao.InventoryDao;
import cova.fss.dao.RequestDao;
import cova.fss.service.InvnetoryService;
import cova.fss.rest.service.RestRequestService;
import cova.fss.dao.UserDao;
import cova.fss.service.LoginService;
import cova.fss.service.RequestService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan(basePackages = {"cova.fss.service", "cova.fss.dao", "cova.fss.controller", "cova.fss.rest",
		"org.springframework.jdbc.datasource.DriverManagerDataSource",
		"org.springframework.jdbc.core.JdbcTemplate"})
public class BeanConfig {
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost/freddysurplussupplies?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		dmds.setSchema("freddysurplussupplies");
		return dmds;
	}
	
	@Bean 
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public RequestService getRequestService() {
		return new RequestService();
	}
	
	@Bean
	public RequestDao getRequestDao() {
		return new RequestDao();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public RestRequestService getRestRequestService() {
		return new RestRequestService();
	}
	
	@Bean
	public LoginService getLoginService() {
		return new LoginService();
	}
	
	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}
	
	@Bean 
	public InvnetoryService getInvnetoryService() {
		return new InvnetoryService();
	}
	
	@Bean 
	public InventoryDao getInvnetoryDao() {
		return new InventoryDao();
	}

}
