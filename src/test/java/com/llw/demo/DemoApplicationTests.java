package com.llw.demo;

import com.llw.demo.dao.*;
import com.llw.demo.service.IAdminService;
import com.llw.demo.service.IUserService;
import com.llw.redis.RedisAccess;
import com.llw.util.CollectionUtil;
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

	@Test
	public void contextLoads() {
		try {
			redisAccess.putObject("bbcc",
					CollectionUtil.fieldMap()
							.put("name", "b")
							.put("age", 18)
							.build()
			);

//			redisAccess.removeObject("bbcc");

//			redisAccess.removeObjectField("bbcc", "name");

			System.out.println(redisAccess.existObjectField("bbcc", "name1"));

//			Human human = redisAccess.getObject("bbcc1", Human.class);
//			System.out.println(human);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
