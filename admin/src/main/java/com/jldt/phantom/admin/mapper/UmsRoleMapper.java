package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleEntity;
import com.jldt.phantom.mgb.model.UmsMenu;
import com.jldt.phantom.mgb.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Ums role mapper.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleMapper.java
 * @Author: system
 * @Date: 2022年03月11日 17时38分14秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsRoleMapper extends BaseMapper<UmsRoleEntity> {

    /**
     * The constant columns.
     */
    String columns = "id,name,description,admin_count,create_time,status,sort";

    /**
     * 根据后台用户ID获取菜单
     *
     * @param adminId the admin id
     * @return the menu list
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取菜单
     *
     * @param roleId the role id
     * @return the menu list by role id
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色ID获取资源
     *
     * @param roleId the role id
     * @return the resource list by role id
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);

}