package com.llw.demo.dao;

import com.llw.demo.entity.Admin;
import com.happy.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
public interface IAdminDao {

    public void add(Admin admin) throws Exception;

    public void addBatch(List<Admin> adminList) throws Exception;

    public void remove(int id) throws Exception;

    public void removeByIds(List<Integer> ids) throws Exception;

    public void update(int id) throws Exception;

    public void update(Admin admin) throws Exception;

    public void update(List<Admin> adminList) throws Exception;

    public Admin get(int id) throws Exception;

    public PagingDto<Admin> query(int pageNo, int pageSize) throws Exception;

    public List<Admin> findAll() throws Exception;

    public List<Admin> findByIds(List<Integer> ids) throws Exception;

}