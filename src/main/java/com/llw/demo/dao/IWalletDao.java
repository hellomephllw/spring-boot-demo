package com.llw.demo.dao;

import com.llw.demo.entity.Wallet;
import com.happy.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
public interface IWalletDao {

    public void add(Wallet wallet) throws Exception;

    public void addBatch(List<Wallet> walletList) throws Exception;

    public void remove(int id) throws Exception;

    public void removeByIds(List<Integer> ids) throws Exception;

    public void update(int id) throws Exception;

    public void update(Wallet wallet) throws Exception;

    public void update(List<Wallet> walletList) throws Exception;

    public Wallet get(int id) throws Exception;

    public PagingDto<Wallet> query(int pageNo, int pageSize) throws Exception;

    public List<Wallet> findAll() throws Exception;

    public List<Wallet> findByIds(List<Integer> ids) throws Exception;

}