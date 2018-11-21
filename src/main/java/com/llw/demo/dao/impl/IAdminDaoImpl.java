package com.llw.demo.dao.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.IAdminDao;
import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-16
 */
@Repository
public class IAdminDaoImpl extends BaseJpaDao<Admin> implements IAdminDao {

    @Override
    public void add(Admin admin) throws Exception {
        super.save(admin);
    }

    @Override
    public Admin get(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public Admin findByAccountAndPassword(String account, String password) throws Exception {

        List<Admin> admins = super.findQuick(" and account=?1 and password=?2", account, password);

        return admins.size() != 0 ? admins.get(0) : null;
    }

    @Override
    public List<Admin> findByAccount(String account) throws Exception {
        return super.findQuick(" and account=?1", account);
    }

    @Override
    public PagingDto<Admin> query(int pageNo, int pageSize, String name, Boolean active, Date beginCreateTime, Date endCreateTime) throws Exception {
        StringBuilder jpql = new StringBuilder();
        List<Object> params = new ArrayList<>();

        if (name != null && !"".equals(name)) {
            params.add("%" + name + "%");
            jpql.append(" and name like ?" + params.size());
        }
        if (active != null) {
            params.add(active);
            jpql.append(" and active=?" + params.size());
        }
        if (beginCreateTime != null) {
            params.add(beginCreateTime);
            jpql.append(" and createTime>=?" + params.size());
        }
        if (endCreateTime != null) {
            params.add(endCreateTime);
            jpql.append(" and createTime<=?" + params.size());
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

}
