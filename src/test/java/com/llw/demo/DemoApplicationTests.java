package com.llw.demo;

import com.llw.demo.dao.*;
import com.llw.demo.service.IMailService;
import com.happy.redis.RedisAccess;
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
			adminDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
