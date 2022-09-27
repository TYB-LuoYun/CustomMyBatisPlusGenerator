package com.ruoyi.module.sys.service;

import com.ruoyi.module.sys.entity.Exam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ftm
 * @since 2022-09-19
 */
public interface IExamService extends IService<Exam> {


    IPage  pages(QueryWrapper  querys, IPage page);

    /**
     * 添加
     *
     * @param exam 
     * @return int
     */
    int add(Exam exam);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param exam 
     * @return int
     */
    int updateData(Exam exam);

    /**
     * id查询数据
     *
     * @param id id
     * @return Exam
     */
    Exam findById(Long id);


    /**
     * 关联查询
     */
    IPage pagesAssociate(Map<String, Object> params, IPage page);


}
