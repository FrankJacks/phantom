package com.jldt.phantom.common.base;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: BaseServiceImpl
 * @Author: 史俊鹏
 * @Date: 2019/5/3/003 下午 10:37
 * @Description:
 * @email ==>> shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected BaseMapper<T> baseMapper;

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public List findAll() {
        return (List<T>) baseMapper.selectAll();
    }

    @Override
    public T findByPrimaryKey(Object key) {
        return (T) baseMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return baseMapper.insertSelective(t);
    }

    @Override
    public int insertList(List<T> t) {
        return baseMapper.insertList(t);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return baseMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public T selectOneByExample(Object example) {
        return baseMapper.selectOneByExample(example);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public List<T> select(T record){
        return baseMapper.select(record);
    }

    @Override
    public T selectOne(T record){
        return baseMapper.selectOne(record);
    }

}
