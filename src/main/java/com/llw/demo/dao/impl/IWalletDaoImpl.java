package com.llw.demo.dao.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.IWalletDao;
import com.llw.demo.entity.Wallet;
import com.llw.dto.PagingDto;
import com.llw.util.StringSql;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2018-11-22
*/
@Repository
public class IWalletDaoImpl extends BaseJpaDao<Wallet> implements IWalletDao {

    @Override
    public void add(Wallet wallet) throws Exception {
        super.save(wallet);
    }

    @Override
    public void addBatch(List<Wallet> wallets) throws Exception {
        super.saveBatch(wallets);
    }

    @Override
    public void remove(long id) throws Exception {
        super.deleteById(id);
    }

    @Override
    public void removeByIds(List<Long> ids) throws Exception {
        super.deleteByIds(ids);
    }

    @Override
    public void update(long id) throws Exception {
        super.execDml("update User set todo=?1 where id=?2", Arrays.asList(null, id).toArray());
    }

    @Override
    public void update(Wallet wallet) throws Exception {
        super.update(wallet);
    }

    @Override
    public void update(List<Wallet> wallets) throws Exception {
        super.updateBatch(wallets);
    }

    @Override
    public Wallet get(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<Wallet> query(int pageNo, int pageSize) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (pageNo == -1) {
            jpql.add(" and todo=?");
            params.add("");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @Override
    public List<Wallet> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<Wallet> findByIds(List<Long> ids) throws Exception {
        return super.findByIds(ids);
    }

}
