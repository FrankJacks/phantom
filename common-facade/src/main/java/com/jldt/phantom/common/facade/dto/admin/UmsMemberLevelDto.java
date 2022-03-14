package com.jldt.phantom.common.facade.dto.admin;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Copyright (C), 2021, 久瓴（上海）科技有限公司
 * @ProjectName: phantom
 * @FileName: UmsMemberLevelDto.java
 * @Author: system
 * @Date: 2022年03月14日 13时42分04秒
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UmsMemberLevelDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "")
    private String name;
    @ApiModelProperty(value = "")
    private Integer growthPoint;
    @ApiModelProperty(value = "是否为默认等级：0->不是；1->是")
    private Integer defaultStatus;
    @ApiModelProperty(value = "免运费标准")
    private BigDecimal freeFreightPoint;
    @ApiModelProperty(value = "每次评价获取的成长值")
    private Integer commentGrowthPoint;
    @ApiModelProperty(value = "是否有免邮特权")
    private Integer priviledgeFreeFreight;
    @ApiModelProperty(value = "是否有签到特权")
    private Integer priviledgeSignIn;
    @ApiModelProperty(value = "是否有评论获奖励特权")
    private Integer priviledgeComment;
    @ApiModelProperty(value = "是否有专享活动特权")
    private Integer priviledgePromotion;
    @ApiModelProperty(value = "是否有会员价格特权")
    private Integer priviledgeMemberPrice;
    @ApiModelProperty(value = "是否有生日特权")
    private Integer priviledgeBirthday;
    @ApiModelProperty(value = "")
    private String note;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}