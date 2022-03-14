package com.jldt.phantom.admin.controller;

import com.jldt.phantom.admin.service.UmsResourceCategoryService;
import com.jldt.phantom.common.api.CommonResult;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceCategoryEntity;
import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.UmsResourceCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 *
 * @author 史俊鹏
 * @date 2020/2/5
 */
@Controller
@Api(tags = "后台资源分类管理", value = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategoryEntity> resourceList = resourceCategoryService.findAll();
        return CommonResult.success(BeanUtil.turnToDtos(UmsResourceCategory.class, resourceList));
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> create(@RequestBody UmsResourceCategory umsResourceCategory) {
        int count = resourceCategoryService.insert(BeanUtil.turnToDto(UmsResourceCategoryEntity.class, umsResourceCategory));
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> update(@RequestBody UmsResourceCategory umsResourceCategory) {
        int count = resourceCategoryService.updateByPrimaryKeySelective(BeanUtil.turnToDto(UmsResourceCategoryEntity.class, umsResourceCategory));
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = resourceCategoryService.deleteByPrimaryKey(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
