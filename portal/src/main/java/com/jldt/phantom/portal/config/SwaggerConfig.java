package com.jldt.phantom.portal.config;

import com.jldt.phantom.common.config.BaseSwaggerConfig;
import com.jldt.phantom.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by 史俊鹏 on 2021/12/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.jldt.phantom.portal.controller")
                .title("园区-移动端业务相关接口")
                .description("园区-移动端业务相关接口")
                .contactName("史俊鹏")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
