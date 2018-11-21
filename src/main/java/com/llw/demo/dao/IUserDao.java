package com.llw.demo.dao;

import com.llw.demo.dto.UserWithWalletDto;
import com.llw.demo.entity.User;
import com.llw.dto.PagingDto;

import java.util.List;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-20
 */
public interface IUserDao {

    public void add(User user) throws Exception;

    public void remove(long id) throws Exception;

    public void update(long id, String name) throws Exception;

    public void update(User user) throws Exception;

    public User get(long id) throws Exception;

    public PagingDto<User> query(int pageNo, int pageSize, String name) throws Exception;

    public List<User> findAll() throws Exception;

    public List<UserWithWalletDto> findAllUsersWithWallet() throws Exception;

}
