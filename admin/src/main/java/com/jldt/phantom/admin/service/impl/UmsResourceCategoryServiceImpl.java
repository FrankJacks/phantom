package com.jldt.phantom.admin.service.impl;

import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsResourceCategoryMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceCategoryEntity;
import com.jldt.phantom.admin.service.UmsResourceCategoryService;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsResourceCategoryService.java
 * @Author: system
 * @Date: 2022年03月14日 11时54分27秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsResourceCategoryServiceImpl extends BaseServiceImpl<UmsResourceCategoryEntity> implements UmsResourceCategoryService {

    private final UmsResourceCategoryMapper umsResourceCategoryMapper;

    public UmsResourceCategoryServiceImpl(UmsResourceCategoryMapper umsResourceCategoryMapper) {
        super(umsResourceCategoryMapper);
        this.umsResourceCategoryMapper = umsResourceCategoryMapper;
    }

}
