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
 * @FileName: UmsMemberLevelEntity.java
 * @Author: system
 * @Date: 2022年03月14日 13时42分04秒
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
@Table(name = "ums_member_level")
public class UmsMemberLevelEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static String DEFAULT_STATUS = "defaultStatus";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *
     */
    @Column(name = "name")
    private String name;
    /**
     *
     */
    @Column(name = "growth_point")
    private Integer growthPoint;
    /**
     * 是否为默认等级：0->不是；1->是
     */
    @Column(name = "default_status")
    private Integer defaultStatus;
    /**
     * 免运费标准
     */
    @Column(name = "free_freight_point")
    private BigDecimal freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
    @Column(name = "priviledge_free_freight")
    private Integer priviledgeFreeFreight;
    /**
     * 是否有签到特权
     */
    @Column(name = "priviledge_sign_in")
    private Integer priviledgeSignIn;
    /**
     * 是否有评论获奖励特权
     */
    @Column(name = "priviledge_comment")
    private Integer priviledgeComment;
    /**
     * 是否有专享活动特权
     */
    @Column(name = "priviledge_promotion")
    private Integer priviledgePromotion;
    /**
     * 是否有会员价格特权
     */
    @Column(name = "priviledge_member_price")
    private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
    @Column(name = "priviledge_birthday")
    private Integer priviledgeBirthday;
    /**
     *
     */
    @Column(name = "note")
    private String note;


}