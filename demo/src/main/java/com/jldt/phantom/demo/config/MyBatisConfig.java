package com.jldt.phantom.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by 史俊鹏 on 2021/12/8.
 */
@Configuration
@MapperScan("com.jldt.phantom.mapper")
public class MyBatisConfig {
}
