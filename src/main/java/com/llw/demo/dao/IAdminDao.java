package com.llw.demo.dao;

import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-16
 */
public interface IAdminDao {

    public void add(Admin admin) throws Exception;

    public Admin get(long id) throws Exception;

    public Admin findByAccountAndPassword(String account, String password) throws Exception;

    public List<Admin> findByAccount(String account) throws Exception;

    public PagingDto<Admin> query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception;

}
