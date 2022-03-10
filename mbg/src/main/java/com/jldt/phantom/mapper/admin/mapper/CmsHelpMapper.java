package com.jldt.phantom.mapper.admin.mapper;

import com.jldt.phantom.common.base.BaseMapper;
import com.jldt.phantom.facade.entity.admin.CmsHelpEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: CmsHelpMapper.java
 * @Author: system
 * @Date: 2021年12月24日 16时23分37秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Mapper
public interface  CmsHelpMapper extends BaseMapper<CmsHelpEntity>{

	String columns="id,category_id,icon,title,show_status,create_time,read_count,content";

}