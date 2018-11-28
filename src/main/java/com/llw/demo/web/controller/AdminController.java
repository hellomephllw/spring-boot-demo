package com.llw.demo.web.controller;

import com.llw.base.ResultVo;
import com.llw.demo.dto.AdminTokenDto;
import com.llw.demo.dto.vo.AdminVo;
import com.llw.demo.entity.Admin;
import com.llw.demo.service.IAdminService;
import com.llw.dto.PagingDto;
import com.llw.util.PagingUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Api(value = "AdminController", description = "管理端-管理员模块")
@RestController
@RequestMapping("/api/manage/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "管理员登陆", response = AdminTokenDto.class)
    @PostMapping("/login")
    public ResultVo login(@ApiParam(value = "账号") @RequestParam String account,
                          @ApiParam(value = "密码") @RequestParam String password,
                          @ApiIgnore HttpServletRequest request) throws Exception {

        AdminTokenDto adminTokenDto = adminService.login(account, password);

        if (adminTokenDto != null) {
            return new ResultVo<>(1, "登陆成功", adminTokenDto);
        }

        return new ResultVo<>(0, "登陆失败", null);
    }

    @ApiOperation(value = "管理员分页查询", response = AdminVo.class, responseContainer = "List")
    @PostMapping("/query")
    public ResultVo query(@RequestParam int pageNo,
                          @RequestParam int pageSize,
                          @ApiParam(value = "名字") @RequestParam(required = false) String name,
                          @ApiParam(value = "是否激活") @RequestParam(required = false) Boolean active,
                          @ApiParam(value = "创建的起始时间") @RequestParam(required = false) Date beginCreateTime,
                          @ApiParam(value = "创建的结束时间") @RequestParam(required = false) Date endCreateTime) throws Exception {

        PagingDto<Admin> pagingDto = adminService.query(pageNo, pageSize, name, active, beginCreateTime, endCreateTime);

        return new ResultVo<>(1, "", PagingUtil.transformPagingDtoToVo(pagingDto, AdminVo.class, pageNo, pageSize));
    }


}
