package com.community.services.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

// 发布到独立的Tomcat需要继承SpringBootServletInitializer类并重写configure方法

@Configuration // 通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = "com.community.services") // 配置扫描包
public class SpringConfig extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 设置启动类，用于独立tomcat运行的入口
		return builder.sources(SpringConfig.class);
	}

	/**
	 * 定义数据源bean
	 */
	/*@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/myblog?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("Easy@0122");
		return dataSource;
	}*/

	/**
	 * 定义事务管理bean
	 */
	/*@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());// 注入dataSource
		return transactionManager;
	}*/

	/**
	 * 定义TransactionTemplate类型的bean
	 */
	/*@Bean
	public TransactionTemplate transactionTemplate() {
		TransactionTemplate transactionTemplate=new TransactionTemplate();
		transactionTemplate.setTransactionManager(transactionManager());//注入事务管理器
		return transactionTemplate;
	}*/

}