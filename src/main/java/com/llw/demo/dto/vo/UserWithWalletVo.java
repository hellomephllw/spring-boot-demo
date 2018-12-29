package com.llw.demo.dto.vo;

import com.llw.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@ApiModel(value = "管理端-用户钱包值对象")
@Data
public class UserWithWalletVo extends BaseVo {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "钱")
    private BigDecimal money;

}
