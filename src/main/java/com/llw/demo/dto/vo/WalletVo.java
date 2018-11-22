package com.llw.demo.dto.vo;

import com.llw.base.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Data
public class WalletVo extends BaseVo {

    private BigDecimal money;

}
