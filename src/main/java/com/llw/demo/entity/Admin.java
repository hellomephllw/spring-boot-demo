package com.llw.demo.entity;

import com.llw.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Entity
@Table(name = "demo_admin")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class Admin extends BaseEntity {

    @Column
    private Date createTime;//在数据库时间都默认存储为timestamp
    @Column
    private boolean active = false;//指定默认值
    @Column(length = 25, nullable = false)
    private String name;
    @Column(length = 30, nullable = false, unique = true)
    private String account;
    @Column(length = 50, nullable = false)
    private String password;

}
