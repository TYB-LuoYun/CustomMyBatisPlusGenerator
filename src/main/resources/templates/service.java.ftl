package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {


    IPage  pages(QueryWrapper  querys, IPage page);

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
    int add(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
    int updateData(${entity} ${entity?uncap_first});

    /**
     * id查询数据
     *
     * @param id id
     * @return ${entity}
     */
    ${entity} findById(Long id);


    /**
     * 关联查询
     */
    IPage pagesAssociate(Map<String, Object> params, IPage page);


}
</#if>
