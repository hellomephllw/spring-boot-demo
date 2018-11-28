package com.llw.demo.dao.merchant.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.merchant.INewsDao;
import com.llw.demo.entity.merchant.News;
import com.llw.dto.PagingDto;
import com.llw.util.StringSql;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2018-11-27
*/
@Repository
public class INewsDaoImpl extends BaseJpaDao<News> implements INewsDao {

    @Override
    public void add(News news) throws Exception {
        super.save(news);
    }

    @Override
    public void addBatch(List<News> newsList) throws Exception {
        super.saveBatch(newsList);
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
    public void update(News news) throws Exception {
        super.update(news);
    }

    @Override
    public void update(List<News> newsList) throws Exception {
        super.updateBatch(newsList);
    }

    @Override
    public News get(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<News> query(int pageNo, int pageSize) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (pageNo == -1) {
            jpql.add(" and todo=?");
            params.add("");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @Override
    public List<News> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<News> findByIds(List<Long> ids) throws Exception {
        return super.findByIds(ids);
    }

}
