package com.jldt.phantom.demo.controller;

import com.jldt.phantom.common.api.CommonResult;
import com.jldt.phantom.demo.service.FeignPortalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用portal接口示例
 * Created by 史俊鹏 on 2019/10/18.
 */
@Api(tags = "FeignPortalController", value = "Feign调用portal接口示例")
@RestController
@RequestMapping("/feign/portal")
public class FeignPortalController {

    @Autowired
    private FeignPortalService portalService;

    @PostMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        return portalService.login(username,password);
    }

    @GetMapping("/cartList")
    public CommonResult cartList() {
        return portalService.list();
    }
}
