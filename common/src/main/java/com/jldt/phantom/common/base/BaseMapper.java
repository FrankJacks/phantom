package com.jldt.phantom.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: BaseMapper
 * @Author: 史俊鹏
 * @Date: 2019/5/3/003 下午 3:10
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface  BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
