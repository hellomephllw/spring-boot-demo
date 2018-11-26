package com.llw.demo.entity.merchant;

import com.llw.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
@Entity
@Table(name = "demo_shop")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends BaseEntity {

    @Column(length = 30, unique = true, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String address;

}
