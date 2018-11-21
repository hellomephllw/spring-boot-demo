package com.llw.demo.web.controller;

import com.llw.base.ResultVo;
import com.llw.demo.service.IAdminService;
import com.llw.dto.PagingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

/**
 * @discription:
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


        return null;
    }

    @PostMapping("/query")
    public PagingDto query(@RequestParam int pageNo,
                           @RequestParam int pageSize,
                           @RequestParam(required = false) String name) throws Exception {

//        adminService.query(pageNo, pageSize, name);

        return null;
    }


}
