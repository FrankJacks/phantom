package com.jldt.phantom.common.base;

import java.util.List;

/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: BaseService
 * @Author: 屈志刚
 * @Date: 2019/5/3/003 下午 10:37
 * @Description:
 * @email ==>> jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface BaseService<T extends BaseEntity> {

    List<T> findAll();

    T findByPrimaryKey(Object key);

    int insert(T t);

    int insertSelective(T t);

    int insertList(List<T> t);

    int deleteByPrimaryKey(Object key);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    T selectOneByExample(Object example);

    List<T> selectByExample(Object example);

    int updateByExample(T record, Object example);

    List<T> select(T t);

    T selectOne(T t);
}
