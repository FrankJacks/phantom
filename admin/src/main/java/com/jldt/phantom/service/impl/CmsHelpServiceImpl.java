package com.jldt.phantom.service.impl;

import com.jldt.phantom.mapper.admin.mapper.CmsHelpMapper;
import org.springframework.stereotype.Service;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.facade.entity.admin.CmsHelpEntity;
import com.jldt.phantom.service.CmsHelpService;


/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: CmsHelpService.java
 * @Author: system
 * @Date: 2021年12月24日 16时23分37秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class CmsHelpServiceImpl extends BaseServiceImpl<CmsHelpEntity> implements CmsHelpService {

    private final CmsHelpMapper cmsHelpMapper;

    public CmsHelpServiceImpl(CmsHelpMapper cmsHelpMapper) {
    	super(cmsHelpMapper);
    	this.cmsHelpMapper = cmsHelpMapper;
    }

}
