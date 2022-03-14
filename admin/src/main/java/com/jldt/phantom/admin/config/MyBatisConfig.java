package com.jldt.phantom.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MyBatis相关配置
 *
 * @author 史俊鹏
 * @date 2021/12/8
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.jldt.phantom.admin.mapper"})
public class MyBatisConfig {
}
