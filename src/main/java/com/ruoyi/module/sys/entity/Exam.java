package com.ruoyi.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ftm
 * @since 2022-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mp_exam")
@ApiModel(value="Exam对象", description="")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Id")
    private String Id;

    @ApiModelProperty(value = "标题")
    @TableField("Title")
    private String Title;

    @ApiModelProperty(value = "内容")
    @TableField("Content")
    private String Content;

    @ApiModelProperty(value = "分类")
    @TableField("Classify")
    private String Classify;

    @TableField("AddAt")
    private Date AddAt;

    @TableField("AddUser")
    private String AddUser;

    @TableField("AddUserName")
    private String AddUserName;

    @TableField("ModifyAt")
    private Date ModifyAt;

    @TableField("ModifyUser")
    private String ModifyUser;

    @TableField("ModifyUserName")
    private String ModifyUserName;

    @TableField("DeletedFlag")
    @TableLogic
    private Integer DeletedFlag;


}
