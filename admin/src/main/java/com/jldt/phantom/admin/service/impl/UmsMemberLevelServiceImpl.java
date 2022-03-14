package com.jldt.phantom.admin.service.impl;

import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.UmsMemberLevel;
import com.jldt.phantom.mgb.model.UmsMemberLevelExample;
import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsMemberLevelMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsMemberLevelEntity;
import com.jldt.phantom.admin.service.UmsMemberLevelService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMemberLevelService.java
 * @Author: system
 * @Date: 2022年03月14日 13时42分04秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsMemberLevelServiceImpl extends BaseServiceImpl<UmsMemberLevelEntity> implements UmsMemberLevelService {

    private final UmsMemberLevelMapper umsMemberLevelMapper;

    public UmsMemberLevelServiceImpl(UmsMemberLevelMapper umsMemberLevelMapper) {
        super(umsMemberLevelMapper);
        this.umsMemberLevelMapper = umsMemberLevelMapper;
    }

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        Example example = new Example(UmsMemberLevelEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(UmsMemberLevelEntity.DEFAULT_STATUS, defaultStatus);
        return BeanUtil.turnToDtos(UmsMemberLevel.class, umsMemberLevelMapper.selectByExample(example));
    }

}
