package com.llw.demo.dao.merchant;

import com.llw.demo.entity.merchant.News;
import com.happy.dto.PagingDto;

import java.util.List;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
public interface INewsDao {

    public void add(News news) throws Exception;

    public void addBatch(List<News> newsList) throws Exception;

    public void remove(int id) throws Exception;

    public void removeByIds(List<Integer> ids) throws Exception;

    public void update(int id) throws Exception;

    public void update(News news) throws Exception;

    public void update(List<News> newsList) throws Exception;

    public News get(int id) throws Exception;

    public PagingDto<News> query(int pageNo, int pageSize) throws Exception;

    public List<News> findAll() throws Exception;

    public List<News> findByIds(List<Integer> ids) throws Exception;

}