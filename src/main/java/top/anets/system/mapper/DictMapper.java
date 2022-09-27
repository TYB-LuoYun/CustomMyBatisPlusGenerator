package top.anets.system.mapper;

import top.anets.system.entity.Dict;
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
 * @since 2022-09-13
 */
public interface DictMapper extends BaseMapper<Dict> {
     IPage pagesAssociate(IPage page, @Param("param") Map<String, Object> params);


}