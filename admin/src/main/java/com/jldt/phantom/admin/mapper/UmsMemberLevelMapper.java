package com.jldt.phantom.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.common.facade.entity.admin.UmsMemberLevelEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMemberLevelMapper.java
 * @Author: system
 * @Date: 2022年03月14日 13时42分04秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UmsMemberLevelMapper extends BaseMapper<UmsMemberLevelEntity> {

    String columns = "id,name,growth_point,default_status,free_freight_point,comment_growth_point,priviledge_free_freight,priviledge_sign_in,priviledge_comment,priviledge_promotion,priviledge_member_price,priviledge_birthday,note,create_by,create_time,update_by,update_time";

}