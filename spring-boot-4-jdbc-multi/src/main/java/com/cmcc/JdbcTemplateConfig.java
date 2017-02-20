package com.cmcc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * JdbcTemplateConfig�������������ڶ����ݿ������ļ�������£�
 * ������ʹ���ĸ����ݿ������ļ���
 * 
 * ����ͨ������һ��Bean��ʵ�ֵģ������������ļ�
 */
@Configuration	//@Configuration���ã���ʾ�����������࣬����������xml�����ļ��е�<beans>��ǩ��@Beanע��������xml�����ļ��е�<bean>��ǩ
public class JdbcTemplateConfig {
	
	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")	//@Qualifier��@Autowired������ǰ���Ǹ��ݾ���������ע��bean�������Ǹ���������ע��bean����������һ���ӿ��ж��ʵ����ʱ���ʺ���ǰ��
	@ConfigurationProperties(prefix = "spring.datasource.primary")	//@ConfigurationProperties���ã��������ļ������ص�bean DataSource��
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryJdbcTemplate")	//@Beanע�����ã��������ķ���ֵ��Ϊbean�浽������
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
