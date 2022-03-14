package com.jldt.phantom.admin.service;

import com.jldt.phantom.admin.dto.UmsMenuNode;
import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.facade.entity.admin.UmsMenuEntity;
import com.jldt.phantom.mgb.model.UmsMenu;

import java.util.List;

/**
 * The interface Ums menu service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMenuService.java
 * @Author: system
 * @Date: 2022年03月14日 13时29分32秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsMenuService extends BaseService<UmsMenuEntity> {

    /**
     * 创建后台菜单
     *
     * @param umsMenu the ums menu
     * @return the int
     */
    int create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     *
     * @param id      the id
     * @param umsMenu the ums menu
     * @return the int
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 根据ID获取菜单详情
     *
     * @param id the id
     * @return the item
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     *
     * @param id the id
     * @return the int
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     *
     * @param parentId the parent id
     * @param pageSize the page size
     * @param pageNum  the page num
     * @return the list
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     *
     * @return the list
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     *
     * @param id     the id
     * @param hidden the hidden
     * @return the int
     */
    int updateHidden(Long id, Integer hidden);
}
