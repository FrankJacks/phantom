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
 * @FileName: UmsAdminLoginLogDto.java
 * @Author: system
 * @Date: 2022年03月14日 15时03分56秒
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UmsAdminLoginLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "")
    private Integer adminId;
    @ApiModelProperty(value = "")
    private String ip;
    @ApiModelProperty(value = "")
    private String address;
    @ApiModelProperty(value = "浏览器登录类型")
    private String userAgent;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}