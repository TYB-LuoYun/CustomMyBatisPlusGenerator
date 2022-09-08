package top.anets.system.controller;

import org.springframework.web.bind.annotation.*;
import top.anets.system.service.IUserOrgDeptService;
import top.anets.system.entity.UserOrgDept;
import top.anets.system.vo.UserOrgDeptVo;
import top.anets.base.WrapperQuery;
import top.anets.base.PageQuery;
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
 * @since 2022-09-07
 */
@Api(tags = {""})
@RestController
@RequestMapping("/user-org-dept")
public class UserOrgDeptController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserOrgDeptService userOrgDeptService;


    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(@RequestBody UserOrgDept userOrgDept){
         userOrgDeptService.saveOrUpdate(userOrgDept);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("saveOrUpdateCustom")
    public void saveOrUpdateCustom(@RequestBody UserOrgDeptVo userOrgDeptVo){
        //todo yourself
        userOrgDeptService.saveOrUpdate(WrapperQuery.from(userOrgDeptVo, UserOrgDept.class));
    }



    @ApiOperation(value = "删除")
    @RequestMapping("deletes")
    public void deletes(String... ids){
         userOrgDeptService.removeByIds(Arrays.asList(ids));
    }

    @ApiOperation(value = "Id查询")
    @GetMapping("/detail/{id}")
    public UserOrgDept findById(@PathVariable Long id){
        return userOrgDeptService.findById(id);
    }




    @ApiOperation(value = "查询-分页-查询和返回不处理")
    @RequestMapping("pages")
    public IPage pages(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return userOrgDeptService.pages(WrapperQuery.query(params), query.Page());
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
        IPage<UserOrgDeptVo> pages = null;
        if(query == null){
           pages = userOrgDeptService.pages(WrapperQuery.parse(params, UserOrgDeptVo.class), query.Page());

         }else{
            pages = userOrgDeptService.pages(WrapperQuery.parse(params, UserOrgDeptVo.class), WrapperQuery.page(params));
         }

          pages.getRecords().forEach(item->{
       //         todo    item.get...

          });
         return pages;
    }




    @ApiOperation(value = "关联查询-分页")
    @PostMapping("pagesAssociate")
    public IPage pagesAssociate(@RequestParam(required = false)  Map<String,Object> params, PageQuery query){
        return userOrgDeptService.pagesAssociate(params, query.Page());
    }


 }
