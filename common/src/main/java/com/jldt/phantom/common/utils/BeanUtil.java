package com.jldt.phantom.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.ReflectUtils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: BeanUtil
 * @Author: 曹旭楠
 * @Date: 2019/5/24 10:30 AM
 * @Description: phantom bean工具类
 * @email ==>> caoxunan@midaigroup.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Slf4j
public class BeanUtil {

    /**
     * 功能描述: <br>
     * 〈实现Bean拷贝功能〉
     *
     * @param rClass 返回的Class类型
     * @param t      源对象
     *
     * @return: R   rClass的目标对象
     * @throws:
     * @Version: 1.0.0
     * @Author: 曹旭楠
     * @Date: 10:39 AM 2019/5/24
     */
    public static <T, R> R  turnToDto(Class<R> rClass, T t){
        Function<T, R> turnToDto = source -> {
            if (Objects.isNull(t)) {
                return null;
            }
            Object target = ReflectUtils.newInstance(rClass);
            BeanUtils.copyProperties(source, target);
            return (R) target;
        };

        return turnToDto.apply(t);
    }

    /**
     * 功能描述: <br>
     * 〈实现Bean拷贝功能〉
     *
     * @param rClass 返回的Class类型
     * @param t      源对象集合
     *
     * @return: java.util.List<R>   rClass的目标对象集合
     * @throws:
     * @Version: 1.0.0
     * @Author: 曹旭楠
     * @Date: 10:39 AM 2019/5/24
     */
    public static <T, R> List<R> turnToDtos(Class<R> rClass, List<T> t){
        return t.stream().map(source -> turnToDto(rClass, source)).collect(Collectors.toList());
    }

    /**
     * @param obj1      进行属性比较的对象1
     * @param obj2      进行属性比较的对象2
     * @param ignoreArr 选择忽略比较的属性数组
     * @Author: 史俊鹏
     * @return 属性差异比较结果 map
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] ignoreArr) {
        try {
            Map<String, List<Object>> map = new HashMap<String, List<Object>>();
            List<String> ignoreList = null;
            if (ignoreArr != null && ignoreArr.length > 0) {
                ignoreList = Arrays.asList(ignoreArr);
            }
            //只有两个对象都是同一类型才有可比性
            if (obj1.getClass() == obj2.getClass()) {
                Class clazz = obj1.getClass();
                //获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    if (ignoreList != null && ignoreList.contains(name)) {
                        continue;
                    }
                    //获取属性的get方法
                    Method readMethod = pd.getReadMethod();
                    //在obj1上调用get方法等同于获得obj1的属性值
                    Object o1 = readMethod.invoke(obj1);
                    //在obj2上调用get方法等同于获得obj2的属性值
                    Object o2 = readMethod.invoke(obj2);
                    //如果此属性是时间
                    if (o1 instanceof Timestamp) {
                        o1 = new Date(((Timestamp) o1).getTime());
                    }
                    if (o2 instanceof Timestamp) {
                        o2 = new Date(((Timestamp) o2).getTime());
                    }
                    if (o1 == null && o2 == null) {
                        continue;
                    } else if (o1 == null && o2 != null) {
                        //不一致
                        List<Object> list = new ArrayList<Object>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                        continue;
                    }
                    if (!o1.equals(o2)) {
                        List<Object> list = new ArrayList<>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            log.error("对象比较异常", e);
            return null;
        }
    }

}
