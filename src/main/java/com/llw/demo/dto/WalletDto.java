package com.llw.demo.dto;

import com.llw.base.BaseDto;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-21
 */
@Data
public class WalletDto extends BaseDto {

    private BigDecimal money;

}
