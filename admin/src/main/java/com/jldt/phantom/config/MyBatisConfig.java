package com.jldt.phantom.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 *
 * @author 史俊鹏
 * @date 2021/12/8
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.jldt.phantom.mapper","com.jldt.phantom.dao"})
public class MyBatisConfig {
}
