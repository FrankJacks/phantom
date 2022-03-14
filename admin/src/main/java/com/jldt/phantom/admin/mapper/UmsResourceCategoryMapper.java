package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsResourceCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsResourceCategoryMapper.java
 * @Author: system
 * @Date: 2022年03月14日 11时54分27秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsResourceCategoryMapper extends BaseMapper<UmsResourceCategoryEntity> {

    String columns = "id,name,sort,create_by,create_time,update_by,update_time";

}