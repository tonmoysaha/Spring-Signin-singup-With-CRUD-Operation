package com.spring.app.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.app")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringAppConfiguration {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public DataSource securityDatasource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		
		try {
			datasource.setDriverClass(env.getProperty("com.mysql.jdbc.Driver"));
		} catch (PropertyVetoException exc) {
			// TODO Auto-generated catch block
			throw new RuntimeException(exc);
		}
		datasource.setJdbcUrl(env.getProperty("jdbc.url"));
		datasource.setUser(env.getProperty("jdbc.user"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		datasource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		datasource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		datasource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		datasource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		
		logger.info("username: " + env.getProperty("jdbc.user"));
		
		
		return datasource;
		
	}
	
	
}
