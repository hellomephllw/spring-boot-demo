package com.llw.demo.web.controller;

import com.happy.base.ResultVo;
import com.llw.demo.transfer.UserDto;
import com.llw.demo.transfer.UserWithWalletDto;
import com.llw.demo.transfer.vo.UserVo;
import com.llw.demo.transfer.vo.UserWithWalletVo;
import com.llw.demo.entity.User;
import com.llw.demo.service.IUserService;
import com.happy.dto.PagingDto;
import com.happy.util.ObjectUtil;
import com.happy.util.PagingUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Api(value = "UserController", description = "管理端-用户模块")
@RestController
@RequestMapping("/api/manage/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加", response = ResultVo.class)
    @PostMapping("/add")
    public ResultVo add(@RequestParam String name) throws Exception {

        userService.add(name);

        return new ResultVo<>(1, "添加成功", null);
    }

    @ApiOperation(value = "删除", response = ResultVo.class)
    @PostMapping("/remove")
    public ResultVo remove(@RequestParam int id) throws Exception {

        userService.remove(id);

        return new ResultVo<>(1, "删除成功", null);
    }

    @ApiOperation(value = "修改", response = ResultVo.class)
    @PostMapping("/modify")
    public ResultVo modify(@RequestParam int id,
                           @RequestParam String name) throws Exception {

        userService.modify(id, name);

        return new ResultVo<>(1, "修改成功", null);
    }

    @ApiOperation(value = "获取用户", response = UserVo.class)
    @PostMapping("/get")
    public ResultVo get(@RequestParam int id) throws Exception {

        return new ResultVo<>(1, "", ObjectUtil.transferObjectValToAnother(userService.get(id), UserVo.class));
    }

    @ApiOperation(value = "用户分页查询", response = UserVo.class, responseContainer = "List")
    @PostMapping("/query")
    public ResultVo query(@RequestParam int pageNo,
                          @RequestParam int pageSize,
                          @RequestParam(required = false) String name) throws Exception {

        PagingDto<User> pagingDto = userService.query(pageNo, pageSize, name);

        return new ResultVo<>(1, "", PagingUtil.transformPagingDtoToVo(pagingDto, UserVo.class, pageNo, pageSize));
    }

    @ApiOperation(value = "查询所有用户", response = UserVo.class, responseContainer = "List")
    @PostMapping("/findAll")
    public ResultVo findAll() throws Exception {

        List<UserVo> userVos = new ArrayList<>();
        for (User user : userService.findAll()) {
            userVos.add(ObjectUtil.transferObjectValToAnother(user, UserVo.class));
        }

        return new ResultVo<>(1, "", userVos);
    }

    @ApiOperation(value = "查询用户钱包", response = UserWithWalletVo.class, responseContainer = "List")
    @PostMapping("/findAllUserWithWallet")
    public ResultVo findAllUserWithWallet() throws Exception {

        List<UserWithWalletVo> userWithWalletVos = new ArrayList<>();
        for (UserWithWalletDto userWithWalletDto : userService.findAllUserWithWallets()) {
            userWithWalletVos.add(ObjectUtil.transferObjectValToAnother(userWithWalletDto, UserWithWalletVo.class));
        }

        return new ResultVo<>(1, "", userWithWalletVos);
    }

    @ApiOperation(value = "根据名字和年龄查找", response = UserDto.class, responseContainer = "List")
    @PostMapping("/findByNameAndAge")
    public ResultVo findByNameAndAge(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer age) throws Exception {

        return new ResultVo<>(1, "", userService.findByNameAndAge(name, age));
    }

}
