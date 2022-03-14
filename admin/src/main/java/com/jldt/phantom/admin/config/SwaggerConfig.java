package com.jldt.phantom.admin.config;

import com.jldt.phantom.common.config.BaseSwaggerConfig;
import com.jldt.phantom.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author 史俊鹏
 * @date 2021/12/26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.jldt.phantom.admin.controller")
                .title("后台管理系统")
                .description("后台管理系统相关接口文档")
                .contactName("史俊鹏")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
