package com.llw.demo.transfer;

import com.happy.base.BaseThroughDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @description: 用户
 * @author: llw
 * @date: 2019-05-25
 */
@ApiModel(value = "用户数据传输对象")
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class UserDto extends BaseThroughDto {

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "年龄")
    private byte age;
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

}
