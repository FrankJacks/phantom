package com.jldt.phantom.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: BaseMapper
 * @Author: 屈志刚
 * @Date: 2019/5/3/003 下午 3:10
 * @Description:
 * @email ==>> jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface  BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
