package com.jldt.phantom.admin.service.impl;

import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsAdminLoginLogMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminLoginLogEntity;
import com.jldt.phantom.admin.service.UmsAdminLoginLogService;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminLoginLogService.java
 * @Author: system
 * @Date: 2022年03月14日 15时03分56秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsAdminLoginLogServiceImpl extends BaseServiceImpl<UmsAdminLoginLogEntity> implements UmsAdminLoginLogService {

    private final UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    public UmsAdminLoginLogServiceImpl(UmsAdminLoginLogMapper umsAdminLoginLogMapper) {
    	super(umsAdminLoginLogMapper);
    	this.umsAdminLoginLogMapper = umsAdminLoginLogMapper;
    }

}
