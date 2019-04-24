package com.llw.demo.transfer.vo;

import com.happy.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@ApiModel(value = "管理端-用户值对象")
@Data
public class UserVo extends BaseVo {

    @ApiModelProperty(value = "姓名")
    private String name;

}
