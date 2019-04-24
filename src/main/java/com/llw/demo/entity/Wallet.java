package com.llw.demo.entity;

import com.happy.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Entity
@Table(name = "demo_wallet")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class Wallet extends BaseEntity {

    @Column(precision = 12, scale = 2)
    private BigDecimal money = new BigDecimal(0);
    @Column
    private long userId;

}
