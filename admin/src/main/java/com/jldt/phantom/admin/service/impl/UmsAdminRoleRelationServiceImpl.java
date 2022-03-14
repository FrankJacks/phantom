package com.jldt.phantom.admin.service.impl;

import com.jldt.phantom.mgb.model.UmsAdminRoleRelationExample;
import com.jldt.phantom.mgb.model.UmsResource;
import com.jldt.phantom.mgb.model.UmsRole;
import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsAdminRoleRelationMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminRoleRelationEntity;
import com.jldt.phantom.admin.service.UmsAdminRoleRelationService;

import java.util.List;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminRoleRelationService.java
 * @Author: system
 * @Date: 2022年03月11日 19时01分23秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsAdminRoleRelationServiceImpl extends BaseServiceImpl<UmsAdminRoleRelationEntity> implements UmsAdminRoleRelationService {

    private final UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    public UmsAdminRoleRelationServiceImpl(UmsAdminRoleRelationMapper umsAdminRoleRelationMapper) {
    	super(umsAdminRoleRelationMapper);
    	this.umsAdminRoleRelationMapper = umsAdminRoleRelationMapper;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return umsAdminRoleRelationMapper.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return umsAdminRoleRelationMapper.getResourceList(adminId);
    }

    @Override
    public List<Long> getAdminIdList(Long resourceId) {
        return umsAdminRoleRelationMapper.getAdminIdList(resourceId);
    }

    @Override
    public void deleteByExample(UmsAdminRoleRelationExample adminRoleRelationExample) {
        umsAdminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
    }
}
