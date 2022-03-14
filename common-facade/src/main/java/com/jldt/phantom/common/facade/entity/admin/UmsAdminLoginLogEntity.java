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
 * @FileName: UmsAdminLoginLogEntity.java
 * @Author: system
 * @Date: 2022年03月14日 15时03分56秒
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
@Table(name = "ums_admin_login_log")
public class UmsAdminLoginLogEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *
     */
    @Column(name = "admin_id")
    private Long adminId;
    /**
     *
     */
    @Column(name = "ip")
    private String ip;
    /**
     *
     */
    @Column(name = "address")
    private String address;
    /**
     * 浏览器登录类型
     */
    @Column(name = "user_agent")
    private String userAgent;


}