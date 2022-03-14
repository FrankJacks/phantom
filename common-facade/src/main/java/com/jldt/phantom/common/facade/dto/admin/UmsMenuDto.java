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
 * @FileName: UmsMenuDto.java
 * @Author: system
 * @Date: 2022年03月14日 13时29分32秒
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UmsMenuDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "父级ID")
    private Integer parentId;
    @ApiModelProperty(value = "菜单名称")
    private String title;
    @ApiModelProperty(value = "菜单级数")
    private Integer level;
    @ApiModelProperty(value = "菜单排序")
    private Integer sort;
    @ApiModelProperty(value = "前端名称")
    private String name;
    @ApiModelProperty(value = "前端图标")
    private String icon;
    @ApiModelProperty(value = "前端隐藏")
    private Integer hidden;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}