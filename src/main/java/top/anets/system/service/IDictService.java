package top.anets.system.service;

import top.anets.system.entity.Dict;
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
 * @since 2022-09-13
 */
public interface IDictService extends IService<Dict> {


    IPage  pages(QueryWrapper  querys, IPage page);

    /**
     * 添加
     *
     * @param dict 
     * @return int
     */
    int add(Dict dict);

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
     * @param dict 
     * @return int
     */
    int updateData(Dict dict);

    /**
     * id查询数据
     *
     * @param id id
     * @return Dict
     */
    Dict findById(Long id);


    /**
     * 关联查询
     */
    IPage pagesAssociate(Map<String, Object> params, IPage page);


}
