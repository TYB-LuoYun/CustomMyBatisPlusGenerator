package ${package.Mapper};

import ${package.Entity}.${entity};
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
 * @author ${author}
 * @since ${date}
 */
public interface ${table.mapperName} extends BaseMapper<${entity}> {
     IPage pagesAssociate(IPage page, @Param("param") Map<String, Object> params);


}