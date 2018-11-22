package com.llw.demo.dto.vo;

import com.llw.base.BaseVo;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@Data
public class AdminVo extends BaseVo {

    private String account;

    private String name;

    private boolean active;

    private java.sql.Date createTime;

    public Date getCreateTime() {
        return new Date(createTime.getTime());
    }

}
