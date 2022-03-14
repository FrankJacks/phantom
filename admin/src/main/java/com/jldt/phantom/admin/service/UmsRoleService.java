package com.jldt.phantom.admin.service;

import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleEntity;
import com.jldt.phantom.mgb.model.UmsMenu;
import com.jldt.phantom.mgb.model.UmsResource;
import com.jldt.phantom.mgb.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ums role service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleService.java
 * @Author: system
 * @Date: 2022年03月11日 17时38分14秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsRoleService extends BaseService<UmsRoleEntity> {

    /**
     * Create int.
     *
     * @param role the role
     * @return the int
     */
    int create(UmsRole role);

    /**
     * Update int.
     *
     * @param role the role
     * @return the int
     */
    int update(UmsRole role);

    /**
     * Delete int.
     *
     * @param ids the ids
     * @return the int
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     *
     * @return the list
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     *
     * @param keyword  the keyword
     * @param pageSize the page size
     * @param pageNum  the page num
     * @return the list
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据管理员ID获取对应菜单
     *
     * @param adminId the admin id
     * @return the menu list
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     *
     * @param roleId the role id
     * @return the list
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     *
     * @param roleId the role id
     * @return the list
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     *
     * @param roleId  the role id
     * @param menuIds the menu ids
     * @return the int
     */
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     *
     * @param roleId      the role id
     * @param resourceIds the resource ids
     * @return the int
     */
    int allocResource(Long roleId, List<Long> resourceIds);
}
