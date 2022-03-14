package com.jldt.phantom.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.jldt.phantom.admin.dto.UmsMenuNode;
import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.UmsMenu;
import com.jldt.phantom.mgb.model.UmsMenuExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.jldt.phantom.admin.mapper.UmsMenuMapper;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.facade.entity.admin.UmsMenuEntity;
import com.jldt.phantom.admin.service.UmsMenuService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMenuService.java
 * @Author: system
 * @Date: 2022年03月14日 13时29分32秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UmsMenuServiceImpl extends BaseServiceImpl<UmsMenuEntity> implements UmsMenuService {

    private final UmsMenuMapper umsMenuMapper;

    public UmsMenuServiceImpl(UmsMenuMapper umsMenuMapper) {
        super(umsMenuMapper);
        this.umsMenuMapper = umsMenuMapper;
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return umsMenuMapper.insertSelective(BeanUtil.turnToDto(UmsMenuEntity.class, umsMenu));
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenuEntity parentMenu = umsMenuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return umsMenuMapper.updateByPrimaryKeySelective(BeanUtil.turnToDto(UmsMenuEntity.class, umsMenu));
    }

    @Override
    public UmsMenu getItem(Long id) {

        return BeanUtil.turnToDto(UmsMenu.class, umsMenuMapper.selectByPrimaryKey(id));
    }

    @Override
    public int delete(Long id) {

        return umsMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMenuExample example = new UmsMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return BeanUtil.turnToDtos(UmsMenu.class, umsMenuMapper.selectByExample(example));
    }

    @Override
    public List<UmsMenuNode> treeList() {

        List<UmsMenu> menuList = BeanUtil.turnToDtos(UmsMenu.class, umsMenuMapper.selectAll());

        return menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return umsMenuMapper.updateByPrimaryKeySelective(BeanUtil.turnToDto(UmsMenuEntity.class, umsMenu));
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

}
