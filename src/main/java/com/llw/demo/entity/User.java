package com.llw.demo.entity;

import com.llw.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 用户实体
 * @author: llw
 * @date: 2018-11-15
 */
@Entity
@Table(name = "demo_user")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class User extends BaseEntity {

    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

}
