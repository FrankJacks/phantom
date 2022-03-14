package com.jldt.phantom.admin.service;

import com.jldt.phantom.admin.dto.UmsAdminParam;
import com.jldt.phantom.admin.dto.UpdateAdminPasswordParam;
import com.jldt.phantom.common.api.CommonResult;
import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.domain.UserDto;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminEntity;
import com.jldt.phantom.mgb.model.UmsAdmin;
import com.jldt.phantom.mgb.model.UmsResource;
import com.jldt.phantom.mgb.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ums admin service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminService.java
 * @Author: system
 * @Date: 2022年03月14日 13时54分19秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsAdminService extends BaseService<UmsAdminEntity> {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username the username
     * @return the admin by username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @param umsAdminParam the ums admin param
     * @return the ums admin
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果 common result
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户id获取用户
     *
     * @param id the id
     * @return the item
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param keyword  the keyword
     * @param pageSize the page size
     * @param pageNum  the page num
     * @return the list
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     *
     * @param id    the id
     * @param admin the admin
     * @return the int
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     *
     * @param id the id
     * @return the int
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     *
     * @param adminId the admin id
     * @param roleIds the role ids
     * @return the int
     */

    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     *
     * @param adminId the admin id
     * @return the role list
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     *
     * @param adminId the admin id
     * @return the resource list
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 修改密码
     *
     * @param updatePasswordParam the update password param
     * @return the int
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     *
     * @param username the username
     * @return the user dto
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     *
     * @return the current admin
     */
    UmsAdmin getCurrentAdmin();

}
