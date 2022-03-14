package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsRoleMenuRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsRoleMenuRelationMapper.java
 * @Author: system
 * @Date: 2022年03月11日 18时18分14秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsRoleMenuRelationMapper extends BaseMapper<UmsRoleMenuRelationEntity> {

    String columns = "id,role_id,menu_id,create_by,create_time,update_by,update_time";

}