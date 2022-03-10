package com.jldt.phantom.service;

import com.jldt.phantom.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 * Created by 史俊鹏 on 2021/12/26.
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
