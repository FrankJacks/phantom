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
 * @FileName: UmsAdminEntity.java
 * @Author: system
 * @Date: 2022年03月14日 13时54分19秒
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
@Table(name = "ums_admin")
public class UmsAdminEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String USER_NAME = "username";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *
     */
    @Column(name = "username")
    private String username;
    /**
     *
     */
    @Column(name = "password")
    private String password;
    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 备注信息
     */
    @Column(name = "note")
    private String note;
    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;
    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @Column(name = "status")
    private Integer status;


}