package com.mtc.app.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ComponentScan("com.mtc.app")
@Configuration
public class AppConfig {
	
	@Bean(name="basicDataSource")
	public BasicDataSource getBasicDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("krishna229");
		
		return basicDataSource;
		
	}

	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJDBCTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		jdbcTemplate.setDataSource(getBasicDataSource());
		
		return jdbcTemplate;
	}
	
	@Bean(name="namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		
		NamedParameterJdbcTemplate parameterJdbcTemplate = new NamedParameterJdbcTemplate(getBasicDataSource());
		
		return parameterJdbcTemplate;
	}
}
