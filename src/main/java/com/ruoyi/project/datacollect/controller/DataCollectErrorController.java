package com.ruoyi.project.datacollect.controller;

import org.springframework.web.bind.annotation.*;
import com.ruoyi.project.datacollect.service.IDataCollectErrorService;
import com.ruoyi.project.datacollect.entity.DataCollectError;
import com.ruoyi.project.datacollect.vo.DataCollectErrorVo;
import com.ruoyi.project.base.WrapperQuery;
import com.ruoyi.project.base.PageQuery;
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
 * 数据采集异常表 前端控制器
 * </p>
 * @author ftm
 * @since 2024-04-22
 */
@Api(tags = {"数据采集异常表"})
@RestController
@RequestMapping("/data-collect-error")
public class DataCollectErrorController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDataCollectErrorService dataCollectErrorService;


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void addOrModify(@RequestBody DataCollectErrorVo dataCollectErrorVo){
        //todo yourself
        dataCollectErrorService.saveOrUpdate(WrapperQuery.from(dataCollectErrorVo, DataCollectError.class));
    }

    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         dataCollectErrorService.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public DataCollectError findById(@PathVariable Long id){
        return dataCollectErrorService.getById(id);
    }


    @ApiOperation(value = "查询-分页")
    @RequestMapping("lists")
    public IPage lists(  DataCollectErrorVo dataCollectErrorVo, PageQuery query){
        IPage  pages = dataCollectErrorService.page(query.Page(),WrapperQuery.query(dataCollectErrorVo));
        WrapperQuery.ipage(pages,DataCollectErrorVo.class).getRecords().forEach(item->{
        //         todo    item.get...

        });
        return pages;
    }

 }
