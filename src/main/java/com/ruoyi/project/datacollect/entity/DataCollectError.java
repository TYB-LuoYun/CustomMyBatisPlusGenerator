package com.ruoyi.project.datacollect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据采集异常表
 * </p>
 *
 * @author ftm
 * @since 2024-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("data_collect_error")
@ApiModel(value="DataCollectError对象", description="数据采集异常表")
public class DataCollectError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String belong;

    @ApiModelProperty(value = "数据id")
    private String dataId;

    @ApiModelProperty(value = "数据内容")
    private String dataContent;

    @ApiModelProperty(value = "查询信息(语句或者请求参数)")
    private String queryInfo;

    @ApiModelProperty(value = "错误原因")
    private String errMsg;

    @ApiModelProperty(value = "重试次数")
    private Integer retry;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
