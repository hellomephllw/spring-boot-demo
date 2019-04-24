package com.llw.demo.transfer;

import com.happy.base.BaseDto;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@Data
public class WalletDto extends BaseDto {

    private BigDecimal money;

}
