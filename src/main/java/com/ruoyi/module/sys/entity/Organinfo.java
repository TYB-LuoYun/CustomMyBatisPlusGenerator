package com.ruoyi.module.sys.entity;

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
 * 机构表
 * </p>
 *
 * @author ftm
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_organinfo")
@ApiModel(value="Organinfo对象", description="机构表")
public class Organinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构ID")
    @TableId("OrganID")
    private String OrganID;

    @ApiModelProperty(value = "机构编号（医院编号）")
    @TableField("OrganCode")
    private String OrganCode;

    @ApiModelProperty(value = "机构名(医院名)")
    @TableField("OrganName")
    private String OrganName;

    @ApiModelProperty(value = "机构英文编码")
    @TableField("OrganNameEN")
    private String OrganNameEN;

    @ApiModelProperty(value = "机构全面用于打印报告")
    @TableField("OrganFullName")
    private String OrganFullName;

    @ApiModelProperty(value = "上级机构ID")
    @TableField("OrganParentID")
    private String OrganParentID;

    @ApiModelProperty(value = "卫计委 卫计局 ")
    @TableField("OrganType")
    private String OrganType;

    @ApiModelProperty(value = "纬度")
    @TableField("OrganLatitude")
    private String OrganLatitude;

    @ApiModelProperty(value = "经度")
    @TableField("OrganLongitude")
    private String OrganLongitude;

    @ApiModelProperty(value = "机构地址")
    @TableField("OrganAddress")
    private String OrganAddress;

    @ApiModelProperty(value = "机构电话")
    @TableField("OrganTell")
    private String OrganTell;

    @ApiModelProperty(value = "备注")
    @TableField("Remark")
    private String Remark;

    @ApiModelProperty(value = "排序")
    @TableField("SortNum")
    private Integer SortNum;

    @ApiModelProperty(value = "删除标记")
    @TableField("DeleteFlag")
    private String DeleteFlag;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "街道")
    private String town;

    @ApiModelProperty(value = "院区等级码")
    @TableField("HospitalGradeCode")
    private String HospitalGradeCode;

    @ApiModelProperty(value = "院区等级")
    @TableField("HospitalGradeID")
    private String HospitalGradeID;

    @ApiModelProperty(value = "医院类型")
    @TableField("HospitalType")
    private String HospitalType;

    @ApiModelProperty(value = "医院简介")
    @TableField("Description")
    private String Description;

    @ApiModelProperty(value = "医院图片介绍，数组，轮播图")
    @TableField("Imgs")
    private String Imgs;

    @ApiModelProperty(value = "医院主图")
    @TableField("ImgMain")
    private String ImgMain;

    @ApiModelProperty(value = "官网地址")
    @TableField("WebsiteUrl")
    private String WebsiteUrl;

    @ApiModelProperty(value = "医院logo")
    @TableField("HospitalLogo")
    private String HospitalLogo;

    @ApiModelProperty(value = "添加时间")
    @TableField("AddAt")
    private Date AddAt;

    @ApiModelProperty(value = "修改时间")
    @TableField("ModifyAt")
    private Date ModifyAt;


}
