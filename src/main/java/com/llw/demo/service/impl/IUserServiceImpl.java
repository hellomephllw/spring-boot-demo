package com.llw.demo.service.impl;

import com.llw.demo.dao.IUserDao;
import com.llw.demo.dto.UserWithWalletDto;
import com.llw.demo.entity.User;
import com.llw.demo.service.IUserService;
import com.llw.dto.PagingDto;
import com.llw.exception.BussinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void add(String name) throws Exception {
        if (name == null || "".equals(name)) throw new BussinessException("名称不能为空");

        User user = new User();
        user.setName(name);
        userDao.add(user);
    }

    @Override
    public void remove(long id) throws Exception {
        if (id < 1) throw new BussinessException("id必须大于0");

        userDao.remove(id);
    }

    @Override
    public void modify(long id, String name) throws Exception {
        if (id < 1) throw new BussinessException("id必须大于0");
        if (name == null || "".equals(name)) throw new BussinessException("名称不能为空");

        userDao.update(id, name);
    }

    @Override
    public void modifyWithLock(long id, String name) throws Exception {
        if (id < 1) throw new BussinessException("id必须大于0");
        if (name == null || "".equals(name)) throw new BussinessException("名称不能为空");

        User user = userDao.get(id);
        user.setName(name);

        //有乐观锁
        userDao.update(user);
    }

    @Override
    public User get(long id) throws Exception {
        if (id < 1) throw new BussinessException("id必须大于0");

        return userDao.get(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public PagingDto<User> query(int pageNo, int pageSize, String name) throws Exception {
        if (pageNo < 1) throw new BussinessException("当前页码必须大于0");
        if (pageSize < 1) throw new BussinessException("每页数据量必须大于0");

        return userDao.query(pageNo, pageSize, name);
    }

    @Override
    public List<UserWithWalletDto> findAllUserWithWallets() throws Exception {

        return userDao.findAllUsersWithWallet();
    }

}
