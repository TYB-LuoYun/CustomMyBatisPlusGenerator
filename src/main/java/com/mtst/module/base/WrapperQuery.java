package com.mtst.module.base;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * @Author ftm
 * @Date 2022-09-01 10:49:37
 * @Description Query条件构造器
 */
public class WrapperQuery {

    private static List<String> Exclude = Arrays.asList("current","size","total");

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
        wrapper.eq(map.get(key)!=null, key, map.get(key));
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
    }
