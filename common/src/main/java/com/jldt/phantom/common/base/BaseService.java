package com.jldt.phantom.common.base;

import java.util.List;

/**
 * The interface Base service.
 *
 * @param <T> the type parameter
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: BaseService
 * @Author: 史俊鹏
 * @Date: 2019 /5/3/003 下午 10:37
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc> 作者姓名           修改时间           版本号              描述
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<T> findAll();

    /**
     * Find by primary key t.
     *
     * @param key the key
     * @return the t
     */
    T findByPrimaryKey(Object key);

    /**
     * Insert int.
     *
     * @param t the t
     * @return the int
     */
    int insert(T t);

    /**
     * Insert selective int.
     *
     * @param t the t
     * @return the int
     */
    int insertSelective(T t);

    /**
     * Insert list int.
     *
     * @param t the t
     * @return the int
     */
    int insertList(List<T> t);

    /**
     * Delete by primary key int.
     *
     * @param key the key
     * @return the int
     */
    int deleteByPrimaryKey(Object key);

    /**
     * Update by primary key selective int.
     *
     * @param t the t
     * @return the int
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * Update by primary key int.
     *
     * @param t the t
     * @return the int
     */
    int updateByPrimaryKey(T t);

    /**
     * Select one by example t.
     *
     * @param example the example
     * @return the t
     */
    T selectOneByExample(Object example);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<T> selectByExample(Object example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(T record, Object example);

    /**
     * Select list.
     *
     * @param t the t
     * @return the list
     */
    List<T> select(T t);

    /**
     * Select one t.
     *
     * @param t the t
     * @return the t
     */
    T selectOne(T t);
}
