package com.llw.demo.dto.vo;

import com.llw.base.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@Data
public class UserWithWalletVo extends BaseVo {

    private String name;

    private BigDecimal money;

}
