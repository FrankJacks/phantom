package com.jldt.phantom.portal.config;

import com.jldt.phantom.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置
 *
 * @author 史俊鹏
 * @date 2020/3/2
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
