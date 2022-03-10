package com.jldt.phantom.demo.service;

import com.jldt.phantom.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 史俊鹏 on 2019/10/18.
 */
@FeignClient("portal")
public interface FeignPortalService {

    @PostMapping("/sso/login")
    CommonResult login(@RequestParam String username, @RequestParam String password);

    @GetMapping("/cart/list")
    CommonResult list();
}
