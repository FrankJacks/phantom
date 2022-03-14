package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminRoleRelationEntity;
import com.jldt.phantom.mgb.model.UmsResource;
import com.jldt.phantom.mgb.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Ums admin role relation mapper.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminRoleRelationMapper.java
 * @Author: system
 * @Date: 2022年03月11日 19时01分23秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelationEntity> {

    /**
     * The constant columns.
     */
    String columns = "id,admin_id,role_id,create_by,create_time,update_by,update_time";

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

}