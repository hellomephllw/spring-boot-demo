package com.llw.demo.dto.vo;

import com.happy.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@ApiModel(value = "管理端-钱包值对象")
@Data
public class WalletVo extends BaseVo {

    @ApiModelProperty(value = "钱")
    private BigDecimal money;

}
