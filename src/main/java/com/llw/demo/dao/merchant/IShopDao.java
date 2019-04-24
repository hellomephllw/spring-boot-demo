package com.llw.demo.dao.merchant;

import com.llw.demo.entity.merchant.Shop;
import com.happy.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
public interface IShopDao {

    public void add(Shop shop) throws Exception;

    public void addBatch(List<Shop> shopList) throws Exception;

    public void remove(int id) throws Exception;

    public void removeByIds(List<Integer> ids) throws Exception;

    public void update(int id) throws Exception;

    public void update(Shop shop) throws Exception;

    public void update(List<Shop> shopList) throws Exception;

    public Shop get(int id) throws Exception;

    public PagingDto<Shop> query(int pageNo, int pageSize) throws Exception;

    public List<Shop> findAll() throws Exception;

    public List<Shop> findByIds(List<Integer> ids) throws Exception;

}