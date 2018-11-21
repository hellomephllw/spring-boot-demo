package com.llw.demo.dto.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-21
 */
@Data
public class UserWithWalletVo {

    private long id;

    private String name;

    private BigDecimal money;

}
