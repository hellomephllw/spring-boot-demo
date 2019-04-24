package com.llw.demo.dao.impl;

import com.happy.base.BaseJpaDao;
import com.llw.demo.dao.IUserDao;
import com.llw.demo.entity.User;
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
public class IUserDaoImpl extends BaseJpaDao<User> implements IUserDao {

    @Override
    public void add(User user) throws Exception {
        super.save(user);
    }

    @Override
    public void addBatch(List<User> userList) throws Exception {
        super.saveBatch(userList);
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
    public void update(User user) throws Exception {
        super.update(user);
    }

    @Override
    public void update(List<User> userList) throws Exception {
        super.updateBatch(userList);
    }

    @Override
    public User get(int id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<User> query(int pageNo, int pageSize) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (pageNo == -1) {
            jpql.add(" and todo=?");
            params.add("");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @Override
    public List<User> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<User> findByIds(List<Integer> ids) throws Exception {
        return super.findByIds(ids);
    }

}
