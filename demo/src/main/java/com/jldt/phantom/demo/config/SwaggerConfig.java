package com.jldt.phantom.demo.config;

import com.jldt.phantom.common.config.BaseSwaggerConfig;
import com.jldt.phantom.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author 史俊鹏
 * @date 2021/12/8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.jldt.phantom.demo.controller")
                .title("Demo Case")
                .description("SpringCloud 版本中的一些示例")
                .contactName("史俊鹏")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

}
