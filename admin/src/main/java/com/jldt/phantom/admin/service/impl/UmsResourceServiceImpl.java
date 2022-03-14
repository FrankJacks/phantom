package com.jldt.phantom.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.jldt.phantom.admin.mapper.UmsRoleMapper;
import com.jldt.phantom.admin.mapper.UmsRoleResourceRelationMapper;
import com.jldt.phantom.admin.service.UmsRoleResourceRelationService;
import com.jldt.phantom.admin.service.UmsRoleService;
import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.constant.AuthConstant;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleEntity;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleResourceRelationEntity;
import com.jldt.phantom.common.service.RedisService;
import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsResourceMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceEntity;
import com.jldt.phantom.admin.service.UmsResourceService;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsResourceService.java
 * @Author: system
 * @Date: 2022年03月11日 16时02分00秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsResourceServiceImpl extends BaseServiceImpl<UmsResourceEntity> implements UmsResourceService {

    @Autowired
    private UmsRoleService roleService;

    @Autowired
    private UmsRoleResourceRelationService roleResourceRelationService;

    @Autowired
    private RedisService redisService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private UmsResourceMapper umsResourceMapper;

    public UmsResourceServiceImpl(BaseMapper<UmsResourceEntity> baseMapper) {
        super(baseMapper);
    }

    @Override
    public int create(UmsResource umsResource) {
        UmsResourceEntity umsResourceEntity = BeanUtil.turnToDto(UmsResourceEntity.class, umsResource);
        int count = umsResourceMapper.insertSelective(umsResourceEntity);
        initResourceRolesMap();
        return count;
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        UmsResourceEntity umsResourceEntity = BeanUtil.turnToDto(UmsResourceEntity.class, umsResource);
        int count = umsResourceMapper.updateByPrimaryKeySelective(umsResourceEntity);
        initResourceRolesMap();
        return count;
    }

    @Override
    public UmsResource getItem(Long id) {
        return BeanUtil.turnToDto(UmsResource.class, umsResourceMapper.selectByPrimaryKey(id));
    }

    @Override
    public int delete(Long id) {
        int count = umsResourceMapper.deleteByPrimaryKey(id);
        initResourceRolesMap();
        return count;
    }

    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsResourceExample example = new UmsResourceExample();
        UmsResourceExample.Criteria criteria = example.createCriteria();
        if (categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (StrUtil.isNotEmpty(nameKeyword)) {
            criteria.andNameLike('%' + nameKeyword + '%');
        }
        if (StrUtil.isNotEmpty(urlKeyword)) {
            criteria.andUrlLike('%' + urlKeyword + '%');
        }
        return BeanUtil.turnToDtos(UmsResource.class, umsResourceMapper.selectByExample(example));
    }

    @Override
    public List<UmsResource> listAll() {
        return BeanUtil.turnToDtos(UmsResource.class, umsResourceMapper.selectAll());
    }

    @Override
    public Map<String,List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<UmsResourceEntity> resourceList = umsResourceMapper.selectAll();
        List<UmsRoleEntity> roleList = roleService.findAll();
        List<UmsRoleResourceRelationEntity> relationList = roleResourceRelationService.findAll();
        for (UmsResourceEntity resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UmsRoleResourceRelationEntity::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;

    }

}
