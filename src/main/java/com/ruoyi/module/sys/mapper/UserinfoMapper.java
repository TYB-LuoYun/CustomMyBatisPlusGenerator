package com.ruoyi.module.sys.mapper;

import com.ruoyi.module.sys.entity.Userinfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
    * mapper接口
    * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {
     IPage pagesAssociate(IPage page, @Param("param") Map<String, Object> params);


}