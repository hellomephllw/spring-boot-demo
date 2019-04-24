package com.llw.demo.dao.impl;

import com.happy.base.BaseJpaDao;
import com.llw.demo.dao.IWalletDao;
import com.llw.demo.entity.Wallet;
import com.happy.dto.PagingDto;
import com.happy.util.StringSql;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
@Repository
public class IWalletDaoImpl extends BaseJpaDao<Wallet> implements IWalletDao {

    @Override
    public void add(Wallet wallet) throws Exception {
        super.save(wallet);
    }

    @Override
    public void addBatch(List<Wallet> walletList) throws Exception {
        super.saveBatch(walletList);
    }

    @Override
    public void remove(int id) throws Exception {
        super.deleteById(id);
    }

    @Override
    public void removeByIds(List<Integer> ids) throws Exception {
        super.deleteByIds(ids);
    }

    @Override
    public void update(int id) throws Exception {
        super.execDml("update User set todo=?1 where id=?2", Arrays.asList(null, id).toArray());
    }

    @Override
    public void update(Wallet wallet) throws Exception {
        super.update(wallet);
    }

    @Override
    public void update(List<Wallet> walletList) throws Exception {
        super.updateBatch(walletList);
    }

    @Override
    public Wallet get(int id) throws Exception {
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
    public List<Wallet> findByIds(List<Integer> ids) throws Exception {
        return super.findByIds(ids);
    }

}
