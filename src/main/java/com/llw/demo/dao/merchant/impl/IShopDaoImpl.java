package com.llw.demo.dao.merchant.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.merchant.IShopDao;
import com.llw.demo.entity.merchant.Shop;
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
public class IShopDaoImpl extends BaseJpaDao<Shop> implements IShopDao {

    @Override
    public void add(Shop shop) throws Exception {
        super.save(shop);
    }

    @Override
    public void addBatch(List<Shop> shops) throws Exception {
        super.saveBatch(shops);
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
    public void update(Shop shop) throws Exception {
        super.update(shop);
    }

    @Override
    public void update(List<Shop> shops) throws Exception {
        super.updateBatch(shops);
    }

    @Override
    public Shop get(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<Shop> query(int pageNo, int pageSize) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (pageNo == -1) {
            jpql.add(" and todo=?");
            params.add("");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @Override
    public List<Shop> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<Shop> findByIds(List<Long> ids) throws Exception {
        return super.findByIds(ids);
    }

}
