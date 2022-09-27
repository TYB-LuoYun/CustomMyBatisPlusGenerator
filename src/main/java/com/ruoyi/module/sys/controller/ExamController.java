package com.ruoyi.module.sys.controller;

import org.springframework.web.bind.annotation.*;
import com.ruoyi.module.sys.service.IExamService;
import com.ruoyi.module.sys.entity.Exam;
import com.ruoyi.module.sys.vo.ExamVo;
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
 *  前端控制器
 * </p>
 *
 * @author ftm
 * @since 2022-09-19
 */
@Api(tags = {""})
@RestController
@RequestMapping("/exam")
public class ExamController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IExamService examService;


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(@RequestBody Exam exam){
         examService.saveOrUpdate(exam);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("addOrModify")
    public void addOrModify(@RequestBody ExamVo examVo){
        //todo yourself
        examService.saveOrUpdate(WrapperQuery.from(examVo, Exam.class));
    }



    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         examService.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public Exam findById(@PathVariable Long id){
        return examService.findById(id);
    }




    @ApiOperation(value = "查询-分页-查询和返回不处理")
    @RequestMapping("pages")
    public IPage pages(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return examService.pages(WrapperQuery.query(params), query.Page());
    }


    @ApiOperation(value = "查询-分页-查询和返回新增字段或特殊处理")
    @RequestMapping("lists")
    public IPage lists(@RequestParam(required = false) ExamVo examVo, PageQuery query){
        IPage  pages = examService.pages(WrapperQuery.query(examVo), query.Page());
        WrapperQuery.ipage(pages,ExamVo.class).getRecords().forEach(item->{
        //         todo    item.get...

        });
        return pages;
    }

   





    @ApiOperation(value = "关联查询-分页")
    @PostMapping("pagesAssociate")
    public IPage pagesAssociate(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return examService.pagesAssociate(params, query.Page());
    }


 }
