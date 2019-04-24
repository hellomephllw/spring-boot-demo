package com.llw.demo.dao;

import com.llw.demo.entity.User;
import com.happy.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
public interface IUserDao {

    public void add(User user) throws Exception;

    public void addBatch(List<User> userList) throws Exception;

    public void remove(int id) throws Exception;

    public void removeByIds(List<Integer> ids) throws Exception;

    public void update(int id) throws Exception;

    public void update(User user) throws Exception;

    public void update(List<User> userList) throws Exception;

    public User get(int id) throws Exception;

    public PagingDto<User> query(int pageNo, int pageSize) throws Exception;

    public List<User> findAll() throws Exception;

    public List<User> findByIds(List<Integer> ids) throws Exception;

}