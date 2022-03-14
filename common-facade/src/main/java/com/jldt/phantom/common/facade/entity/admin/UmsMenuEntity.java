package com.jldt.phantom.common.facade.entity.admin;

import com.jldt.phantom.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsMenuEntity.java
 * @Author: system
 * @Date: 2022年03月14日 13时29分32秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ums_menu")
public class UmsMenuEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 菜单名称
     */
    @Column(name = "title")
    private String title;
    /**
     * 菜单级数
     */
    @Column(name = "level")
    private Integer level;
    /**
     * 菜单排序
     */
    @Column(name = "sort")
    private Integer sort;
    /**
     * 前端名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 前端图标
     */
    @Column(name = "icon")
    private String icon;
    /**
     * 前端隐藏
     */
    @Column(name = "hidden")
    private Integer hidden;


}