package com.jldt.phantom.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.jldt.phantom.admin.mapper.UmsRoleMenuRelationMapper;
import com.jldt.phantom.admin.mapper.UmsRoleResourceRelationMapper;
import com.jldt.phantom.admin.service.UmsResourceService;
import com.jldt.phantom.admin.service.UmsRoleMenuRelationService;
import com.jldt.phantom.admin.service.UmsRoleResourceRelationService;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleMenuRelationEntity;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleResourceRelationEntity;
import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsRoleMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleEntity;
import com.jldt.phantom.admin.service.UmsRoleService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleService.java
 * @Author: system
 * @Date: 2022年03月11日 17时38分14秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsRoleServiceImpl extends BaseServiceImpl<UmsRoleEntity> implements UmsRoleService {

    @Autowired
    private UmsResourceService resourceService;

    @Autowired
    private UmsRoleMenuRelationService umsRoleMenuRelationService;

    @Autowired
    private UmsRoleResourceRelationService umsRoleResourceRelationService;

    private final UmsRoleMapper umsRoleMapper;

    public UmsRoleServiceImpl(UmsRoleMapper umsRoleMapper) {
    	super(umsRoleMapper);
    	this.umsRoleMapper = umsRoleMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(UmsRole role) {
        role.setAdminCount(0);
        role.setSort(0);
        return umsRoleMapper.insertSelective(BeanUtil.turnToDto(UmsRoleEntity.class, role));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(UmsRole role) {
        return umsRoleMapper.updateByPrimaryKeySelective(BeanUtil.turnToDto(UmsRoleEntity.class, role));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(List<Long> ids) {
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(ids);
        int count = umsRoleMapper.deleteByExample(example);
        resourceService.initResourceRolesMap();
        return count;
    }

    @Override
    public List<UmsRole> list() {
        return BeanUtil.turnToDtos(UmsRole.class, umsRoleMapper.selectAll());
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample example = new UmsRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return BeanUtil.turnToDtos(UmsRole.class, umsRoleMapper.selectByExample(example));
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return umsRoleMapper.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsRoleMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return umsRoleMapper.getResourceListByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        umsRoleMenuRelationService.deleteByPrimaryKey(roleId);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelationEntity relation = new UmsRoleMenuRelationEntity();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            umsRoleMenuRelationService.insertSelective(relation);
        }
        return menuIds.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        umsRoleResourceRelationService.deleteByPrimaryKey(roleId);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelationEntity relation = new UmsRoleResourceRelationEntity();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            umsRoleResourceRelationService.insertSelective(relation);
        }
        resourceService.initResourceRolesMap();
        return resourceIds.size();
    }


}
