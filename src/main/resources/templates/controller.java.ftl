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
    public void saveOrUpdate(@RequestBody ${entity} ${entity?uncap_first}){
         ${(table.serviceName?substring(1))?uncap_first}.saveOrUpdate(${entity?uncap_first});
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdateCustom")
    public void saveOrUpdateCustom(@RequestBody ${entity}Vo ${entity?uncap_first}Vo){
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
        return ${(table.serviceName?substring(1))?uncap_first}.findById(id);
    }




    @ApiOperation(value = "查询-分页-查询和返回不处理")
    @RequestMapping("pages")
    public IPage pages(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return ${(table.serviceName?substring(1))?uncap_first}.pages(WrapperQuery.query(params), query.Page());
    }


     @ApiOperation(value = "查询-分页-查询和返回新增字段或特殊处理")
    @GetMapping("lists")
    public IPage lists(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return this.list(params,query);
    }

   

    @ApiOperation(value = "查询-分页-查询和返回新增字段或特殊处理")
    @PostMapping("lists")
    public IPage lists(@RequestBody Map<String,Object> params){
        return this.list(params,null);
    }

    private IPage list(Map<String, Object> params, PageQuery query) {
        IPage<${entity}Vo> pages = null;
        if(query == null){
           pages = ${(table.serviceName?substring(1))?uncap_first}.pages(WrapperQuery.parse(params, ${entity}Vo.class), query.Page());

         }else{
            pages = ${(table.serviceName?substring(1))?uncap_first}.pages(WrapperQuery.parse(params, ${entity}Vo.class), WrapperQuery.page(params));
         }

          pages.getRecords().forEach(item->{
       //         todo    item.get...

          });
         return pages;
    }




    @ApiOperation(value = "关联查询-分页")
    @PostMapping("pagesAssociate")
    public IPage pagesAssociate(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return ${(table.serviceName?substring(1))?uncap_first}.pagesAssociate(params, query.Page());
    }


 }
</#if>