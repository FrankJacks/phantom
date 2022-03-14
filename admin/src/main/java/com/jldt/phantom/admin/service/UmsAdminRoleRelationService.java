package com.jldt.phantom.admin.service;

import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminRoleRelationEntity;
import com.jldt.phantom.mgb.model.UmsAdminRoleRelation;
import com.jldt.phantom.mgb.model.UmsAdminRoleRelationExample;
import com.jldt.phantom.mgb.model.UmsResource;
import com.jldt.phantom.mgb.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Ums admin role relation service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminRoleRelationService.java
 * @Author: system
 * @Date: 2022年03月11日 19时01分23秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsAdminRoleRelationService extends BaseService<UmsAdminRoleRelationEntity> {

    /**
     * 获取用于所有角色
     *
     * @param adminId the admin id
     * @return the role list
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     *
     * @param adminId the admin id
     * @return the resource list
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     *
     * @param resourceId the resource id
     * @return the admin id list
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    /**
     * Delete by example.
     *
     * @param adminRoleRelationExample the admin role relation example
     */
    void deleteByExample(UmsAdminRoleRelationExample adminRoleRelationExample);
}
