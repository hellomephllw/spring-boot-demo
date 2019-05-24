package com.llw.demo.dao.impl;

import com.happy.base.BaseJpaDao;
import com.llw.demo.dao.IAdminDao;
import com.llw.demo.entity.Admin;
import com.happy.dto.PagingDto;
import com.happy.util.StringSql;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
* @description:
* @author: liliwen
* @date: 2019-02-10
*/
@Repository
public class IAdminDaoImpl extends BaseJpaDao<Admin> implements IAdminDao {

    @Override
    public void add(Admin admin) throws Exception {
        super.save(admin);
    }

    @Override
    public void addBatch(List<Admin> adminList) throws Exception {
        super.saveBatch(adminList);
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
    public void update(Admin admin) throws Exception {
        super.update(admin);
    }

    @Override
    public void update(List<Admin> adminList) throws Exception {
        super.updateBatch(adminList);
    }

    @Override
    public Admin get(int id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<Admin> query(int pageNo, int pageSize) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (pageNo == -1) {
            jpql.add(" and todo=?");
            params.add("");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<Admin> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<Admin> findByIds(List<Integer> ids) throws Exception {
        return super.findByIds(ids);
    }

}
