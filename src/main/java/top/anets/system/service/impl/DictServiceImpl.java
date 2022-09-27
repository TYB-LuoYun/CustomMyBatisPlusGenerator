package top.anets.system.service.impl;

import top.anets.system.entity.Dict;
import top.anets.system.mapper.DictMapper;
import top.anets.system.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import top.anets.base.WrapperQuery;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ftm
 * @since 2022-09-13
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    @Override
    public IPage pages(QueryWrapper  querys, IPage page) {
        return baseMapper.selectPage(page,querys );
    }

    @Override
    public int add(Dict dict){
        return baseMapper.insert(dict);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Dict dict){
        return baseMapper.updateById(dict);
    }

    @Override
    public Dict findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public IPage pagesAssociate(Map<String, Object>  params, IPage page) {
        return baseMapper.pagesAssociate(page ,params);
    }



}
