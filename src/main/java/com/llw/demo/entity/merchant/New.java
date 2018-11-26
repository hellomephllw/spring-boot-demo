package com.llw.demo.entity.merchant;

import com.llw.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-24
 */
@Entity
@Table(name = "demo_new")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class New extends BaseEntity {

    @Column(columnDefinition = "text", nullable = false)
    private String content;//富文本内容的单位(包括blob也这样定义)

}
