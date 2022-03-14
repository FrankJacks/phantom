package com.jldt.phantom.admin.service;

import com.jldt.phantom.common.base.BaseService;
import com.jldt.phantom.common.facade.entity.admin.UmsMemberLevelEntity;
import com.jldt.phantom.mgb.model.UmsMemberLevel;

import java.util.List;

/**
 * The interface Ums member level service.
 *
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMemberLevelService.java
 * @Author: system
 * @Date: 2022年03月14日 13时42分04秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface UmsMemberLevelService extends BaseService<UmsMemberLevelEntity> {

    /**
     * 获取所有会员登录
     *
     * @param defaultStatus 是否为默认会员
     * @return the list
     */
    List<UmsMemberLevel> list(Integer defaultStatus);

}
