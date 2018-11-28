package com.llw.demo.web.controller;

import com.llw.base.ResultVo;
import com.llw.demo.dto.vo.AdminVo;
import com.llw.demo.entity.Admin;
import com.llw.demo.service.IAdminService;
import com.llw.dto.PagingDto;
import com.llw.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@RestController
@RequestMapping("/api/manage/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/login")
    public ResultVo login(@RequestParam String account,
                          @RequestParam String password,
                          @ApiIgnore HttpSession session) throws Exception {

        Admin admin = adminService.login(account, password);

        if (admin != null) {
            //todo session

            return new ResultVo<>(1, "登陆成功", null);
        }

        return new ResultVo<>(0, "登陆失败", null);
    }

    @PostMapping("/query")
    public ResultVo query(@RequestParam int pageNo,
                          @RequestParam int pageSize,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) Boolean active,
                          @RequestParam(required = false) Date beginCreateTime,
                          @RequestParam(required = false) Date endCreateTime) throws Exception {

        PagingDto<Admin> pagingDto = adminService.query(pageNo, pageSize, name, active, beginCreateTime, endCreateTime);

        return new ResultVo<>(1, "", PagingUtil.transformPagingDtoToVo(pagingDto, AdminVo.class, pageNo, pageSize));
    }


}
