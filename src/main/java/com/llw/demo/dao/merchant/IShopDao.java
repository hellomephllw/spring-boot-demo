package com.llw.demo.dao.merchant;

import com.llw.demo.entity.merchant.Shop;
import com.llw.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2018-11-22
*/
public interface IShopDao {

    public void add(Shop shop) throws Exception;

    public void addBatch(List<Shop> shops) throws Exception;

    public void remove(long id) throws Exception;

    public void removeByIds(List<Long> ids) throws Exception;

    public void update(long id) throws Exception;

    public void update(Shop shop) throws Exception;

    public void update(List<Shop> shops) throws Exception;

    public Shop get(long id) throws Exception;

    public PagingDto<Shop> query(int pageNo, int pageSize) throws Exception;

    public List<Shop> findAll() throws Exception;

    public List<Shop> findByIds(List<Long> ids) throws Exception;

}