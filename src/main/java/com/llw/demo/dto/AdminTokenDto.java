package com.llw.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-28
 */
@ApiModel(value = "管理端-token")
@Data
public class AdminTokenDto {

    @ApiModelProperty(value = "token")
    private String token;

}
