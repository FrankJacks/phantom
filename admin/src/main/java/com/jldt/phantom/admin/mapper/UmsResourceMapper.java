package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceEntity;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsResourceMapper.java
 * @Author: system
 * @Date: 2022年03月11日 16时02分00秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsResourceMapper extends BaseMapper<UmsResourceEntity> {

    String columns = "id,create_time,name,url,description,category_id";

}