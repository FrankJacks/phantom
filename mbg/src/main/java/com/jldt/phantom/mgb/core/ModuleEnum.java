package com.jldt.phantom.mgb.core;

import lombok.Getter;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: twin-park
 * @FileName: moduleEnum
 * @Author: 史俊鹏
 * @Date: 2021/12/24/005 下午 1:13
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Getter
public enum ModuleEnum {

    /** cms服务*/
    cms,
    /** admin服务*/
    admin,
    /** 鉴权中心*/
    auth,
    /** 移动端服务*/
    portal;
}
