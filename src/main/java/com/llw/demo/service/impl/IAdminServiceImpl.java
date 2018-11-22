package com.llw.demo.service.impl;

import com.llw.demo.dao.IAdminDao;
import com.llw.demo.entity.Admin;
import com.llw.demo.service.IAdminService;
import com.llw.dto.PagingDto;
import com.llw.exception.BussinessException;
import com.llw.util.CollectionUtil;
import com.llw.util.DateUtil;
import com.llw.util.PagingUtil;
import com.llw.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
public class IAdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Override
    public void add(String account, String name) throws Exception {
        if (account == null || "".equals(account)) throw new BussinessException("账号不能为空");
        if (!RegexUtil.test(RegexUtil._REGEX_MOBILE, account)) throw new BussinessException("账号必须是手机号码");
        if (name == null || "".equals(name)) throw new BussinessException("名字不能为空");

        Admin admin = new Admin();
        admin.setCreateTime(DateUtil.transformUtilDateToSqlDate(new Date()));
        admin.setActive(true);
        admin.setName(name);
        admin.setAccount(account);
        admin.setPassword("123456");

        adminDao.add(admin);
    }

    @Override
    public Admin login(String account, String password) throws Exception {
        if (account == null || "".equals(account)) throw new BussinessException("账号不能为空");
        if (password == null || "".equals(password)) throw new BussinessException("密码不能为空");

        return adminDao.findByAccountAndPassword(account, password);
    }

    @Override
    public boolean accountExist(String account) throws Exception {
        if (account == null || "".equals(account)) throw new BussinessException("账号不能为空");

        return adminDao.findByAccount(account).size() > 0;
    }

    @Override
    public PagingDto query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception {
        if (pageNo < 1) throw new BussinessException("当前页码必须大于0");
        if (pageSize < 1) throw new BussinessException("每页数据量必须大于0");

        return adminDao.query(pageNo, pageSize, name, active, beginCreateTime, endCreateTime);
    }
}
