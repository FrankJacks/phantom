package com.jldt.phantom.facade.dto.admin;


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
 * @FileName: CmsHelpDto.java
 * @Author: system
 * @Date: 2021年12月24日 16时23分37秒
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class CmsHelpDto implements Serializable {

    private static final long serialVersionUID = 1L;

	    @ApiModelProperty(value="id")
    private Long id;
		    @ApiModelProperty(value="")
    private Integer categoryId;
		    @ApiModelProperty(value="")
    private String icon;
		    @ApiModelProperty(value="")
    private String title;
		    @ApiModelProperty(value="")
    private Integer showStatus;
		    @ApiModelProperty(value="")
    private Date createTime;
		    @ApiModelProperty(value="")
    private Integer readCount;
		    @ApiModelProperty(value="")
    private String content;
	
}