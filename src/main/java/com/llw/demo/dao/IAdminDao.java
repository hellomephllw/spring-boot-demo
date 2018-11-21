package com.llw.demo.dao;

import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-16
 */
public interface IAdminDao {

    public PagingDto<Admin> query(int pageNo, int pageSize, String name) throws Exception;

}
