package com.ruoyi.module.sys.vo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.module.sys.controller.PageVo;
import com.ruoyi.module.sys.entity.Organinfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class  OrganinfoVo extends Organinfo implements PageVo {

}