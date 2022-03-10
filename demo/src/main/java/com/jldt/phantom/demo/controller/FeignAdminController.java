package com.jldt.phantom.demo.controller;

/**
 * Created by 史俊鹏 on 2019/10/18.
 */

import com.jldt.phantom.common.api.CommonResult;
import com.jldt.phantom.demo.dto.UmsAdminLoginParam;
import com.jldt.phantom.demo.service.FeignAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用admin接口示例
 */
@Api(tags = "FeignAdminController", value = "Feign调用admin接口示例")
@RestController
@RequestMapping("/feign/admin")
public class FeignAdminController {
    @Autowired
    private FeignAdminService adminService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam) {
        return adminService.login(loginParam);
    }

    @GetMapping("/getBrandList")
    public CommonResult getBrandList(){
        return adminService.getList();
    }
}
