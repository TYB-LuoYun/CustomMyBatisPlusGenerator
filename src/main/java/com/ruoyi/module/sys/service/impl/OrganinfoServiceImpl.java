package com.ruoyi.module.sys.service.impl;

import com.ruoyi.module.sys.entity.Organinfo;
import com.ruoyi.module.sys.mapper.OrganinfoMapper;
import com.ruoyi.module.sys.service.IOrganinfoService;
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
 * 机构表 服务实现类
 * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
@Service
public class OrganinfoServiceImpl extends ServiceImpl<OrganinfoMapper, Organinfo> implements IOrganinfoService {

    @Override
    public IPage pages(QueryWrapper  querys, IPage page) {
        return baseMapper.selectPage(page,querys );
    }

    @Override
    public int add(Organinfo organinfo){
        return baseMapper.insert(organinfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Organinfo organinfo){
        return baseMapper.updateById(organinfo);
    }

    @Override
    public Organinfo findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public IPage pagesAssociate(Map<String, Object>  params, IPage page) {
        return baseMapper.pagesAssociate(page ,params);
    }



}
