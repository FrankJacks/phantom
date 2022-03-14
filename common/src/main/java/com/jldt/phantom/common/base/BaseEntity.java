package com.jldt.phantom.common.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: BaseEntity
 * @Author: 史俊鹏
 * @Date: 2019/5/3/003 下午 10:30
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
public class BaseEntity implements Serializable {

    public static final String FIELD_CREATE_TIME = "createTime";
    /**
     * 创建人create_by
     */
    @Column(name = "create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 修改人
     */
    @Column(name = "update_by")
    private String updateBy;
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}
