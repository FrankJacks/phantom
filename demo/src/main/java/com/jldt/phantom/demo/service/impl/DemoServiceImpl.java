package com.jldt.phantom.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.jldt.phantom.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DemoService实现类
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public List listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return null;
    }
}
