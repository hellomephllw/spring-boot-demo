package com.llw.demo.entity;

import com.llw.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @discription:
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

    @Column
    private BigDecimal money;
    @Column
    private Long userId;

}
