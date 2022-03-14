package com.jldt.phantom.admin.service.impl;

import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsRoleResourceRelationMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleResourceRelationEntity;
import com.jldt.phantom.admin.service.UmsRoleResourceRelationService;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleResourceRelationService.java
 * @Author: system
 * @Date: 2022年03月11日 18时55分02秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsRoleResourceRelationServiceImpl extends BaseServiceImpl<UmsRoleResourceRelationEntity> implements UmsRoleResourceRelationService {

    private final UmsRoleResourceRelationMapper umsRoleResourceRelationMapper;

    public UmsRoleResourceRelationServiceImpl(UmsRoleResourceRelationMapper umsRoleResourceRelationMapper) {
    	super(umsRoleResourceRelationMapper);
    	this.umsRoleResourceRelationMapper = umsRoleResourceRelationMapper;
    }

}
