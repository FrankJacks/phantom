package com.jldt.phantom.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by 史俊鹏 on 2021/12/8.
 */
@Configuration
@MapperScan({"com.jldt.phantom.mapper","com.jldt.phantom.search.dao"})
public class MyBatisConfig {
}
