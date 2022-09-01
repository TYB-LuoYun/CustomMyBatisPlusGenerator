package com.ruoyi.module.sys.controller;

import org.springframework.web.bind.annotation.*;
import com.ruoyi.module.sys.service.IOrganinfoService;
import com.ruoyi.module.sys.entity.Organinfo;
import com.ruoyi.module.sys.vo.OrganinfoVo;
import com.ruoyi.module.base.WrapperQuery;
import com.ruoyi.module.base.PageQuery;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
@Api(tags = {"机构表"})
@RestController
@RequestMapping("/organinfo")
public class OrganinfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOrganinfoService organinfoService;


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(@RequestBody Organinfo organinfo){
         organinfoService.saveOrUpdate(organinfo);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdateCustom")
    public void saveOrUpdateCustom(@RequestBody OrganinfoVo organinfoVo){
        //todo yourself
        organinfoService.saveOrUpdate(WrapperQuery.from(organinfoVo, Organinfo.class));
    }



    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         organinfoService.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public Organinfo findById(@PathVariable Long id){
        return organinfoService.findById(id);
    }




    @ApiOperation(value = "查询-分页-查询和返回不处理")
    @RequestMapping("pages")
    public IPage pages(@RequestParam(required = false)  Map<String,Object> params){
        return organinfoService.pages(WrapperQuery.query(params), WrapperQuery.page(params));
    }

    @ApiOperation(value = "查询-分页-查询和返回新增字段或特殊处理")
    @PostMapping("lists")
    public IPage lists(@RequestBody Map<String,Object> params){
        //todo yourself
        IPage<OrganinfoVo> pages = organinfoService.pages(WrapperQuery.parse(params, OrganinfoVo.class), WrapperQuery.page(params));
        pages.getRecords().forEach(item->{
//         todo    item.get...

        });
        return pages;
    }




    @ApiOperation(value = "关联查询-分页-侧重于写xml")
    @PostMapping("pagesAssociate")
    public IPage pagesAssociate(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return organinfoService.pagesAssociate(params, query.Page());
    }


 }
