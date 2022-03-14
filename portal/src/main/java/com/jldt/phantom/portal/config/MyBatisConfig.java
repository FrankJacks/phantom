package com.jldt.phantom.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by 史俊鹏 on 2021/12/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.jldt.phantom.portal.mapper","com.jldt.phantom.portal.dao"})
public class MyBatisConfig {
}
