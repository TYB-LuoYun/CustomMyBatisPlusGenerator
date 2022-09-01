package com.ruoyi.module.sys.service;

import com.ruoyi.module.sys.entity.Organinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;

/**
 * <p>
 * 机构表 服务类
 * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
public interface IOrganinfoService extends IService<Organinfo> {


    IPage  pages(QueryWrapper  querys, IPage page);

    /**
     * 添加机构表
     *
     * @param organinfo 机构表
     * @return int
     */
    int add(Organinfo organinfo);

    /**
     * 删除机构表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改机构表
     *
     * @param organinfo 机构表
     * @return int
     */
    int updateData(Organinfo organinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Organinfo
     */
    Organinfo findById(Long id);


    /**
     * 关联查询
     */
    IPage pagesAssociate(Map<String, Object> params, IPage page);


}
