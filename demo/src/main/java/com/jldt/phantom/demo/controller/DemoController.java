package com.jldt.phantom.demo.controller;

import com.jldt.phantom.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 商品管理示例Controller
 */
@Api(tags = "DemoController", value = "商品管理示例接口")
@Controller
public class DemoController {

    @ApiOperation(value = "测试分页列表")
    @RequestMapping(value = "/test/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        return CommonResult.success(null);
    }
}
