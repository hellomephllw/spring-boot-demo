package com.llw.demo.service;

import com.llw.demo.transfer.UserWithWalletDto;
import com.llw.demo.entity.User;
import com.happy.dto.PagingDto;

import java.util.List;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
public interface IUserService {

    public void add(String name) throws Exception;

    public void remove(long id) throws Exception;

    public void modify(long id, String name) throws Exception;

    public void modifyWithLock(long id, String name) throws Exception;

    public User get(long id) throws Exception;

    public List<User> findAll() throws Exception;

    public PagingDto<User> query(int pageNo, int pageSize, String name) throws Exception;

    public List<UserWithWalletDto> findAllUserWithWallets() throws Exception;

}
