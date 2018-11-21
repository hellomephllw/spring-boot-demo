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
 * @discription:
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
    private Date createTime;
    @Column
    private Boolean active;
    @Column
    private String name;
    @Column
    private String account;
    @Column
    private String password;

}
