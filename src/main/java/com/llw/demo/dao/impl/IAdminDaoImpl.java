package com.llw.demo.dao.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.IAdminDao;
import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;
import com.llw.util.StringSql;
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
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (name != null && !"".equals(name)) {
            jpql.add(" and name like ?");
            params.add("%" + name + "%");
        }
        if (active != null) {
            jpql.add(" and active=?");
            params.add(active);
        }
        if (beginCreateTime != null) {
            jpql.add(" and createTime>=?");
            params.add(beginCreateTime);
        }
        if (endCreateTime != null) {
            jpql.add(" and createTime<=?");
            params.add(endCreateTime);
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

}
