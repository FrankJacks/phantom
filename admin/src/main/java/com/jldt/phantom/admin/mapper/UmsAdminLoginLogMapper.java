package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminLoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminLoginLogMapper.java
 * @Author: system
 * @Date: 2022年03月14日 15时03分56秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsAdminLoginLogMapper extends BaseMapper<UmsAdminLoginLogEntity> {

    String columns = "id,admin_id,ip,address,user_agent,create_by,create_time,update_by,update_time";

}