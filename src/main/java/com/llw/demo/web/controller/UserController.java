package com.llw.demo.web.controller;

import com.llw.base.ResultVo;
import com.llw.demo.dto.UserWithWalletDto;
import com.llw.demo.dto.vo.UserVo;
import com.llw.demo.dto.vo.UserWithWalletVo;
import com.llw.demo.entity.User;
import com.llw.demo.service.IUserService;
import com.llw.dto.PagingDto;
import com.llw.util.ObjectUtil;
import com.llw.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
@RestController
@RequestMapping("/api/manage/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResultVo add(@RequestParam String name) throws Exception {

        userService.add(name);

        return new ResultVo<>(1, "添加成功", null);
    }

    @PostMapping("/remove")
    public ResultVo remove(@RequestParam long id) throws Exception {

        userService.remove(id);

        return new ResultVo<>(1, "删除成功", null);
    }

    @PostMapping("/modify")
    public ResultVo modify(@RequestParam long id,
                           @RequestParam String name) throws Exception {

        userService.modify(id, name);

        return new ResultVo<>(1, "修改成功", null);
    }

    @PostMapping("/get")
    public ResultVo get(@RequestParam long id) throws Exception {

        return new ResultVo<>(1, "", ObjectUtil.transferObjectValToAnother(userService.get(id), UserVo.class));
    }

    @PostMapping("/query")
    public ResultVo query(@RequestParam int pageNo,
                          @RequestParam int pageSize,
                          @RequestParam(required = false) String name) throws Exception {

        PagingDto<User> pagingDto = userService.query(pageNo, pageSize, name);

        return new ResultVo<>(1, "", PagingUtil.transformPagingDtoToVo(pagingDto, UserVo.class, pageNo, pageSize));
    }

    @PostMapping("/findAll")
    public ResultVo findAll() throws Exception {

        List<UserVo> userVos = new ArrayList<>();
        for (User user : userService.findAll()) {
            userVos.add(ObjectUtil.transferObjectValToAnother(user, UserVo.class));
        }

        return new ResultVo<>(1, "", userVos);
    }

    @PostMapping("/findAllUserWithWallet")
    public ResultVo findAllUserWithWallet() throws Exception {

        List<UserWithWalletVo> userWithWalletVos = new ArrayList<>();
        for (UserWithWalletDto userWithWalletDto : userService.findAllUserWithWallets()) {
            userWithWalletVos.add(ObjectUtil.transferObjectValToAnother(userWithWalletDto, UserWithWalletVo.class));
        }

        return new ResultVo<>(1, "", userWithWalletVos);
    }

}
