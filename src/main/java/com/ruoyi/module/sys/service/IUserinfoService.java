package com.ruoyi.module.sys.service;

import com.ruoyi.module.sys.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;

/**
 * <p>
 * 员工，医院，卫健，第三方厂商，领导，管理员等等 服务类
 * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
public interface IUserinfoService extends IService<Userinfo> {


    IPage  pages(QueryWrapper  querys, IPage page);

    /**
     * 添加员工，医院，卫健，第三方厂商，领导，管理员等等
     *
     * @param userinfo 员工，医院，卫健，第三方厂商，领导，管理员等等
     * @return int
     */
    int add(Userinfo userinfo);

    /**
     * 删除员工，医院，卫健，第三方厂商，领导，管理员等等
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改员工，医院，卫健，第三方厂商，领导，管理员等等
     *
     * @param userinfo 员工，医院，卫健，第三方厂商，领导，管理员等等
     * @return int
     */
    int updateData(Userinfo userinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Userinfo
     */
    Userinfo findById(Long id);


    /**
     * 关联查询
     */
    IPage pagesAssociate(Map<String, Object> params, IPage page);


}
