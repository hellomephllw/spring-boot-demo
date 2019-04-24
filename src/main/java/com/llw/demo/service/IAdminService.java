package com.llw.demo.service;

import com.llw.demo.transfer.AdminTokenDto;
import com.llw.demo.entity.Admin;
import com.happy.dto.PagingDto;

import java.util.Date;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-15
 */
public interface IAdminService {

    public void add(String account, String name) throws Exception;

    public AdminTokenDto login(String account, String password) throws Exception;

    public boolean accountExist(String account) throws Exception;

    public PagingDto<Admin> query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception;

}
