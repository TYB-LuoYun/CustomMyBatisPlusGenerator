package com.ruoyi.module.base;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.util.*;
/**
 * @Author ftm
 * @Date 2022-09-19 17:54:13
 * @Description Query条件构造器
 */
public class WrapperQuery {



    private static List<String> Exclude = Arrays.asList("current","size","total");

    public  static  QueryWrapper   query(Object vo){
       return query(objectToMap(vo));
    }

    public  static  QueryWrapper   query(Map<String,Object> map){
    if(map==null){
    return new QueryWrapper();
    }
    QueryWrapper wrapper = new QueryWrapper();
    map.entrySet().forEach(item->{
    String key = item.getKey();//字段名
    if(Exclude.contains(key)){
    return;
    }
    if(map.get(key)==null || map.get(key)==""){
    return;
    }
    //            OrganName$like
    String column="";
    if(key.contains("$like")){
    column=key.replace("$like", "");
    wrapper.like(column, map.get(key));
    }else if(key.contains("$lt")){
    column=key.replace("$lt", "");
    wrapper.lt(column, map.get(key));
    }else if(key.contains("$gt")){
    column=key.replace("$gt", "");
    wrapper.gt(column, map.get(key));
    }else if(key.contains("$")){
    //               特殊字段什么都不用做
    }else {
    wrapper.eq(map.get(key)!=null, key, map.get(key));
    }


    });
    return  wrapper;
    }

    public static IPage page(Map<String, Object> params) {
        Long current = (Long) params.get("current");
        Long size = (Long) params.get("size");
        if(current==null||size==null){
            current=1L;
            size=Long.MAX_VALUE;
        }
        IPage page = new Page<>(current, size);
        return page;
    }


    /**
     * 拷贝实体到vo
     * @param source
     * @param t
     * @param <T>
     * @return
     */
    public  static <T> T from(Object source ,Class<T>   t){
        if(source == null){
        return null;
        }
        try {
            T o = t.newInstance();
            BeanUtils.copyProperties(source, o);
            return  o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> QueryWrapper<T> parse(Map<String, Object> params, Class<T> classz) {
        T t = map2Obj(params, classz);
        QueryWrapper<T> query =  WrapperQuery.query(t);
        return  query;
    }



    //java对象转map
    public static Map<String, Object> objectToMap(Object obj)   {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


    public static <T> T map2Obj(Map<String,Object> map,Class<T> clz)  {
        try {
            T obj = clz.newInstance();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for(Field field:declaredFields){
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
            return obj;
        }catch ( Exception e) {
            e.printStackTrace();
            return null;
        }
    }


                    public static <T>  IPage<T> ipage(IPage pages,Class<T> t) {
                        List<T> list = new LinkedList<>();
                            pages.getRecords().forEach(item->{
                            list.add(WrapperQuery.from(item, t));
                            });
                            pages.setRecords(list);
                            return pages;
                            }

}
