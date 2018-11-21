package com.llw.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithWalletDto {

    private long userId;

    private String userName;

    private BigDecimal money;

}
