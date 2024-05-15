package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${cfg.BasicPackage}.${cfg.MouleName}.vo.${entity}Vo;
import ${cfg.BasicPackage}.base.WrapperQuery;
import ${cfg.BasicPackage}.base.PageQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void addOrModify(@RequestBody ${entity}Vo ${entity?uncap_first}Vo){
        //todo yourself
        ${(table.serviceName?substring(1))?uncap_first}.saveOrUpdate(WrapperQuery.from(${entity?uncap_first}Vo, ${entity}.class));
    }

    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         ${(table.serviceName?substring(1))?uncap_first}.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public ${entity} findById(@PathVariable Long id){
        return ${(table.serviceName?substring(1))?uncap_first}.getById(id);
    }


    @ApiOperation(value = "查询-分页")
    @RequestMapping("lists")
    public IPage lists(  ${entity}Vo ${entity?uncap_first}Vo, PageQuery query){
        IPage  pages = ${(table.serviceName?substring(1))?uncap_first}.page(query.Page(),WrapperQuery.query(${entity?uncap_first}Vo));
        WrapperQuery.ipage(pages,${entity}Vo.class).getRecords().forEach(item->{
        //         todo    item.get...

        });
        return pages;
    }

 }
</#if>