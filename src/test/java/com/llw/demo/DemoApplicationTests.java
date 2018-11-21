package com.llw.demo;

import com.google.common.collect.ImmutableMap;
import com.llw.demo.dao.*;
import com.llw.demo.entity.User;
import com.llw.demo.service.IAdminService;
import com.llw.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IAdminDao adminDao;
	@Autowired
	private IUserDao userDao;

	@Test
	public void contextLoads() {
		try {
			System.out.println(userService.findAllUserWithWallets());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
