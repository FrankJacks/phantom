package com.jldt.phantom.admin.service;

import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceEntity;
import com.jldt.phantom.mgb.model.UmsResource;

import java.util.List;
import java.util.Map;

/**
 * The interface Ums resource service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsResourceService.java
 * @Author: system
 * @Date: 2022年03月11日 16时02分00秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsResourceService extends BaseService<UmsResourceEntity> {

    /**
     * 初始化资源角色规则
     *
     * @return the map
     */
    Map<String, List<String>> initResourceRolesMap();

    /**
     * Create int.
     *
     * @param umsResource the ums resource
     * @return the int
     */
    int create(UmsResource umsResource);

    /**
     * Update int.
     *
     * @param id          the id
     * @param umsResource the ums resource
     * @return the int
     */
    int update(Long id, UmsResource umsResource);

    /**
     * Gets item.
     *
     * @param id the id
     * @return the item
     */
    UmsResource getItem(Long id);

    /**
     * Delete int.
     *
     * @param id the id
     * @return the int
     */
    int delete(Long id);

    /**
     * List list.
     *
     * @param categoryId  the category id
     * @param nameKeyword the name keyword
     * @param urlKeyword  the url keyword
     * @param pageSize    the page size
     * @param pageNum     the page num
     * @return the list
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * List all list.
     *
     * @return the list
     */
    List<UmsResource> listAll();
}
