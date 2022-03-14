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
 * @FileName: UmsResourceEntity.java
 * @Author: system
 * @Date: 2022年03月11日 16时02分00秒
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
@Table(name = "ums_resource")
public class UmsResourceEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 资源URL
     */
    @Column(name = "url")
    private String url;
    /**
     * 描述
     */
    @Column(name = "description")
    private String description;
    /**
     * 资源分类ID
     */
    @Column(name = "category_id")
    private Integer categoryId;


}