package com.llw.demo.service;

import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;

import java.util.Date;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
public interface IAdminService {

    public void add(String account, String name) throws Exception;

    public Admin login(String account, String password) throws Exception;

    public boolean accountExist(String account) throws Exception;

    public PagingDto<Admin> query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception;

}
