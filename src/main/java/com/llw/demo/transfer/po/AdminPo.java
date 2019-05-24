package com.llw.demo.transfer.po;

import com.happy.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2019-04-24
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class AdminPo extends BasePo {

    private Date createTime;
    private boolean active;
    private String name;
    private String account;
    private String password;

}
