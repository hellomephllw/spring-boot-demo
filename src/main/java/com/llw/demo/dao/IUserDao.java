package com.llw.demo.dao;

import com.llw.demo.entity.User;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
public interface IUserDao {

    public User get(long id) throws Exception;

}
