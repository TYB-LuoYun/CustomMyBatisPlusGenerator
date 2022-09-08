package com.ruoyi.module.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.module.base.Fields;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.module.sys.service.IUserinfoService;
import com.ruoyi.module.sys.entity.Userinfo;
import com.ruoyi.module.sys.vo.UserinfoVo;
import com.ruoyi.module.base.WrapperQuery;
import com.ruoyi.module.base.PageQuery;
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
 * 员工，医院，卫健，第三方厂商，领导，管理员等等 前端控制器
 * </p>
 *
 * @author ftm
 * @since 2022-09-02
 */
@Api(tags = {"员工，医院，卫健，第三方厂商，领导，管理员等等"})
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserinfoService userinfoService;


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(@RequestBody Userinfo userinfo){
         userinfoService.saveOrUpdate(userinfo);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdateCustom")
    public void saveOrUpdateCustom(@RequestBody UserinfoVo userinfoVo){
        //todo yourself
        userinfoService.saveOrUpdate(WrapperQuery.from(userinfoVo, Userinfo.class));
    }



    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         userinfoService.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public Userinfo findById(@PathVariable Long id){
        return userinfoService.findById(id);
    }




    @ApiOperation(value = "查询-分页-查询和返回不处理")
    @RequestMapping("pages")
    public IPage pages(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return userinfoService.pages(WrapperQuery.query(params), query.Page());
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
        IPage<UserinfoVo> pages = null;
        if(query == null){
           pages = userinfoService.pages(WrapperQuery.parse(params, UserinfoVo.class), query.Page());

         }else{
            pages = userinfoService.pages(WrapperQuery.parse(params, UserinfoVo.class), WrapperQuery.page(params));
         }

//关联条件【{1,2}，{1,3}，{2,4}，{1,4}】,
        LambdaQueryWrapper<Userinfo> userinfoLambdaQueryWrapper = Wrappers.<Userinfo>lambdaQuery();
        Wrappers.<Userinfo>lambdaQuery().eq(Userinfo::getAddAt,1 );



         return pages;
    }




    @ApiOperation(value = "关联查询-分页")
    @PostMapping("pagesAssociate")
    public IPage pagesAssociate(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return userinfoService.pagesAssociate(params, query.Page());
    }

    public static void main(String[] args) {
        String fieldName = Fields.getFieldName(Userinfo::getUserID);
//        System.out.println(fieldName);
        System.out.println("字段名：" +fieldName);
    }



 }
