package com.cmcc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * JdbcTemplateConfig类是用来决定在多数据库配置文件的情况下，
 * 到底用使用哪个数据库配置文件。
 * 
 * 这是通过定义一个Bean来实现的，而不是配置文件
 */
@Configuration	//@Configuration作用：表示该类是配置类，作用类似于xml配置文件中的<beans>标签。@Bean注解类似于xml配置文件中的<bean>标签
public class JdbcTemplateConfig {
	
	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")	//@Qualifier与@Autowired的区别：前者是根据具体名字来注入bean，后者是根据类型来注入bean。当容器中一个接口有多个实现类时，适合用前者
	@ConfigurationProperties(prefix = "spring.datasource.primary")	//@ConfigurationProperties作用：绑定配置文件到返回的bean DataSource中
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryJdbcTemplate")	//@Bean注解作用：将方法的返回值作为bean存到容器中
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
