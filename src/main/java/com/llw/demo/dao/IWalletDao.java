package com.llw.demo.dao;

import com.llw.demo.entity.Wallet;
import com.llw.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2018-11-22
*/
public interface IWalletDao {

    public void add(Wallet wallet) throws Exception;

    public void addBatch(List<Wallet> wallets) throws Exception;

    public void remove(long id) throws Exception;

    public void removeByIds(List<Long> ids) throws Exception;

    public void update(long id) throws Exception;

    public void update(Wallet wallet) throws Exception;

    public void update(List<Wallet> wallets) throws Exception;

    public Wallet get(long id) throws Exception;

    public PagingDto<Wallet> query(int pageNo, int pageSize) throws Exception;

    public List<Wallet> findAll() throws Exception;

    public List<Wallet> findByIds(List<Long> ids) throws Exception;

}