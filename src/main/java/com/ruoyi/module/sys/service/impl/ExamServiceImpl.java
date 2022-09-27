package com.ruoyi.module.sys.service.impl;

import com.ruoyi.module.sys.entity.Exam;
import com.ruoyi.module.sys.mapper.ExamMapper;
import com.ruoyi.module.sys.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import com.ruoyi.module.base.WrapperQuery;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ftm
 * @since 2022-09-19
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

    @Override
    public IPage pages(QueryWrapper  querys, IPage page) {
        return baseMapper.selectPage(page,querys );
    }

    @Override
    public int add(Exam exam){
        return baseMapper.insert(exam);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Exam exam){
        return baseMapper.updateById(exam);
    }

    @Override
    public Exam findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public IPage pagesAssociate(Map<String, Object>  params, IPage page) {
        return baseMapper.pagesAssociate(page ,params);
    }



}
