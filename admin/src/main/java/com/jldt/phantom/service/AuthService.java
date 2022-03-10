package com.jldt.phantom.service;

import com.jldt.phantom.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 认证服务远程调用
 *
 * @author 史俊鹏
 * @date 2021 /12/19
 */
@FeignClient("auth")
public interface AuthService {

    /**
     * Gets access token.
     *
     * @param parameters the parameters
     * @return the access token
     */
    @PostMapping(value = "/oauth/token")
    CommonResult<?> getAccessToken(@RequestParam Map<String, String> parameters);

}
