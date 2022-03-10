package com.jldt.phantom.service.impl;

import com.jldt.phantom.model.UmsMemberLevel;
import com.jldt.phantom.model.UmsMemberLevelExample;
import com.jldt.phantom.mapper.UmsMemberLevelMapper;
import com.jldt.phantom.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * Created by 史俊鹏 on 2021/12/26.
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
