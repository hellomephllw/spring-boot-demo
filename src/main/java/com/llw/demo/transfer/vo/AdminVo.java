package com.llw.demo.transfer.vo;

import com.happy.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@ApiModel(value = "管理端-管理员值对象")
@Data
public class AdminVo extends BaseVo {

    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "是否激活")
    private boolean active;
    @ApiModelProperty(value = "创建时间")
    private java.sql.Date createTime;

    public Date getCreateTime() {
        return new Date(createTime.getTime());
    }

}
