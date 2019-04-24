package com.llw.demo.service.impl;

import com.llw.demo.cache.AuthToken;
import com.llw.demo.constant.AuthTypeConst;
import com.llw.demo.constant.CacheTimeConst;
import com.llw.demo.constant.RedisKey;
import com.llw.demo.dao.IAdminDao;
import com.llw.demo.dto.AdminTokenDto;
import com.llw.demo.entity.Admin;
import com.llw.demo.service.IAdminService;
import com.llw.demo.service.IAuthTokenService;
import com.happy.dto.PagingDto;
import com.happy.exception.BusinessException;
import com.happy.redis.RedisAccess;
import com.happy.util.DateUtil;
import com.happy.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Transactional
@Service
public class IAdminServiceImpl {

//    @Autowired
//    private IAdminDao adminDao;
//    @Autowired
//    private IAuthTokenService authTokenService;
//
//    @Override
//    public void add(String account, String name) throws Exception {
//        if (account == null || "".equals(account)) throw new BusinessException("账号不能为空");
//        if (!RegexUtil.test(RegexUtil._REGEX_MOBILE, account)) throw new BusinessException("账号必须是手机号码");
//        if (name == null || "".equals(name)) throw new BusinessException("名字不能为空");
//
//        Admin admin = new Admin();
//        admin.setCreateTime(DateUtil.transformUtilDateToSqlDate(new Date()));
//        admin.setActive(true);
//        admin.setName(name);
//        admin.setAccount(account);
//        admin.setPassword("123456");
//
//        adminDao.add(admin);
//    }
//
//    @Override
//    public AdminTokenDto login(String account, String password) throws Exception {
//        if (account == null || "".equals(account)) throw new BusinessException("账号不能为空");
//        if (password == null || "".equals(password)) throw new BusinessException("密码不能为空");
//
//        Admin admin = adminDao.findByAccountAndPassword(account, password);
//
//        if (admin != null) {
//            //生成token
//            String token = RedisKey._MANAGE_TOKEN;
//            authTokenService.add(token, AuthTypeConst._MANAGE_ADMIN, CacheTimeConst._MANAGE_ADMIN_EXPIRE);
//
//            //返回token
//            AdminTokenDto adminTokenDto = new AdminTokenDto();
//            adminTokenDto.setToken(token);
//            return adminTokenDto;
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean accountExist(String account) throws Exception {
//        if (account == null || "".equals(account)) throw new BusinessException("账号不能为空");
//
//        return adminDao.findByAccount(account).size() > 0;
//    }
//
//    @Override
//    public PagingDto query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception {
//        if (pageNo < 1) throw new BusinessException("当前页码必须大于0");
//        if (pageSize < 1) throw new BusinessException("每页数据量必须大于0");
//
//        return adminDao.query(pageNo, pageSize, name, active, beginCreateTime, endCreateTime);
//    }
}
