package com.llw.demo.web.controller;

import com.llw.exception.BussinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
@RestController
@RequestMapping("/api/manage/user")
public class UserController {

    @PostMapping("/test")
    public String test() throws Exception {

        return "test";
    }

}
