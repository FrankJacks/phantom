package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminMapper.java
 * @Author: system
 * @Date: 2022年03月14日 13时54分19秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdminEntity>{

	String columns="id,username,password,icon,email,nick_name,note,login_time,status,create_by,create_time,update_by,update_time";

}