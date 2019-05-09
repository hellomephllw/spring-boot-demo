package com.llw.demo.transfer.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2019-04-24
 */
@Entity
@Data
public class AdminPo {

    @Id
    private int id;

    private Date createTime;
    private boolean active;
    private String name;
    private String account;
    private String password;

}
