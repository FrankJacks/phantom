package com.jldt.phantom.admin.service.impl;

import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsRoleMenuRelationMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleMenuRelationEntity;
import com.jldt.phantom.admin.service.UmsRoleMenuRelationService;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleMenuRelationService.java
 * @Author: system
 * @Date: 2022年03月11日 18时18分14秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsRoleMenuRelationServiceImpl extends BaseServiceImpl<UmsRoleMenuRelationEntity> implements UmsRoleMenuRelationService {

    private final UmsRoleMenuRelationMapper umsRoleMenuRelationMapper;

    public UmsRoleMenuRelationServiceImpl(UmsRoleMenuRelationMapper umsRoleMenuRelationMapper) {
    	super(umsRoleMenuRelationMapper);
    	this.umsRoleMenuRelationMapper = umsRoleMenuRelationMapper;
    }

}
