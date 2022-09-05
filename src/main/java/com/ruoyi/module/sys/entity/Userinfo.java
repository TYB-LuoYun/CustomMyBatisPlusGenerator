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
 * 员工，医院，卫健，第三方厂商，领导，管理员等等
 * </p>
 *
 * @author ftm
 * @since 2022-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_userinfo")
@ApiModel(value="Userinfo对象", description="员工，医院，卫健，第三方厂商，领导，管理员等等")
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("UserID")
    private String UserID;

    @ApiModelProperty(value = "用户类型 Normal UserHospitalAdminDepartmentAdmin")
    @TableField("UserType")
    private String UserType;

    @ApiModelProperty(value = "用户编号")
    @TableField("UserCode")
    private String UserCode;

    @ApiModelProperty(value = "用户名")
    @TableField("UserName")
    private String UserName;

    @ApiModelProperty(value = "真实用户名")
    @TableField("RealName")
    private String RealName;

    @ApiModelProperty(value = "英文名")
    @TableField("UserNameEN")
    private String UserNameEN;

    @ApiModelProperty(value = "密码")
    @TableField("UserPassword")
    private String UserPassword;

    @ApiModelProperty(value = "性别")
    @TableField("UserSex")
    private String UserSex;

    @ApiModelProperty(value = "用户类型 1患者，2医生")
    @TableField("UserCategory")
    private String UserCategory;

    @ApiModelProperty(value = "出生日期")
    @TableField("UserBirth")
    private Date UserBirth;

    @ApiModelProperty(value = "入职时间")
    @TableField("EntryDate")
    private Date EntryDate;

    @ApiModelProperty(value = "离职时间")
    @TableField("QuitDate")
    private Date QuitDate;

    @ApiModelProperty(value = "身份证")
    @TableField("IDCardNO")
    private String IDCardNO;

    @ApiModelProperty(value = "社保卡号")
    @TableField("PatientKindCardNO")
    private String PatientKindCardNO;

    @ApiModelProperty(value = "用户手机")
    @TableField("UserMobile")
    private String UserMobile;

    @ApiModelProperty(value = "用户座机")
    @TableField("UserTell")
    private String UserTell;

    @ApiModelProperty(value = "省")
    @TableField("Province")
    private String Province;

    @ApiModelProperty(value = "市")
    @TableField("City")
    private String City;

    @ApiModelProperty(value = "区")
    @TableField("District")
    private String District;

    @ApiModelProperty(value = "住址")
    @TableField("UserAddress")
    private String UserAddress;

    @TableField("UserEmail")
    private String UserEmail;

    @ApiModelProperty(value = "备注")
    @TableField("UserRemark")
    private String UserRemark;

    @ApiModelProperty(value = "机构编号")
    @TableField("OrganID")
    private String OrganID;

    @ApiModelProperty(value = "机构名")
    @TableField("OrganName")
    private String OrganName;

    @ApiModelProperty(value = "科室编号")
    @TableField("DepartmentID")
    private String DepartmentID;

    @ApiModelProperty(value = "科室名")
    @TableField("Departmentname")
    private String Departmentname;

    @ApiModelProperty(value = "最后登录日期")
    @TableField("LogonState")
    private Date LogonState;

    @ApiModelProperty(value = "是否锁住")
    @TableField("ISLocked")
    private String ISLocked;

    @ApiModelProperty(value = "排序")
    @TableField("SortNum")
    private Integer SortNum;

    @ApiModelProperty(value = "删除标记")
    @TableField("DeleteFlag")
    private String DeleteFlag;

    @TableField("CheckCode")
    private String CheckCode;

    @ApiModelProperty(value = "密码加密salt")
    @TableField("Salt")
    private String Salt;

    @ApiModelProperty(value = "签名图像路径")
    @TableField("SignImage")
    private String SignImage;

    @ApiModelProperty(value = "签名图像路径root")
    @TableField("SignImageDir")
    private String SignImageDir;

    @ApiModelProperty(value = "第三方Code")
    @TableField("RISCode")
    private String RISCode;

    @ApiModelProperty(value = "微信小程序openid")
    @TableField("WechatOpenID")
    private String WechatOpenID;

    @ApiModelProperty(value = "平台登录授权唯一ID")
    @TableField("GateWayOpenID")
    private String GateWayOpenID;

    @ApiModelProperty(value = "头像")
    @TableField("AvatarUrl")
    private String AvatarUrl;

    @ApiModelProperty(value = "注册时间")
    @TableField("AddAt")
    private Date AddAt;


}
