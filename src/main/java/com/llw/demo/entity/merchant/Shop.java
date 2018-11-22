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

    @Column
    private String name;
    @Column
    private String address;

}
