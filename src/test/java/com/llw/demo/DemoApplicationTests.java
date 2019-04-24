package com.llw.demo;

import com.llw.demo.dao.*;
import com.llw.demo.service.IAdminService;
import com.llw.demo.service.IMailService;
import com.llw.demo.service.IUserService;
import com.happy.redis.RedisAccess;
import com.happy.util.CollectionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisAccess redisAccess;

	@Autowired
	private IMailService mailService;

	@Test
	public void contextLoads() {
		try {
//			mailService.sendSimpleMail("hellomephllw@163.com", "测试主题1", "测试的邮件内容");
//			mailService.sendAttachmentsMail("hellomephllw@163.com", "测试主题2", "测试的邮件内容");
//			mailService.sendInlineResourceMail("hellomephllw@163.com", "测试主题3", "测试的邮件内容");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
