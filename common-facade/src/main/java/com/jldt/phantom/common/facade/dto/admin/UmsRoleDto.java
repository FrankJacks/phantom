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
 * @FileName: UmsRoleDto.java
 * @Author: system
 * @Date: 2022年03月11日 17时38分14秒
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UmsRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "后台用户数量")
    private Integer adminCount;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;
    @ApiModelProperty(value = "")
    private Integer sort;

}