package com.llw.demo.dao.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.IUserDao;
import com.llw.demo.dto.UserWithWalletDto;
import com.llw.demo.entity.User;
import com.llw.dto.PagingDto;
import com.llw.util.StringSql;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-20
 */
@Repository
public class IUserDaoImpl extends BaseJpaDao<User> implements IUserDao {

    @Override
    public void add(User user) throws Exception {
        super.save(user);
    }

    @Override
    public void remove(long id) throws Exception {
        super.deleteById(id);
    }

    @Override
    public void update(long id, String name) throws Exception {
        super.execDml("update User set name=?1 where id=?2", Arrays.asList(name, id).toArray());
    }

    @Override
    public void update(User user) throws Exception {
        super.update(user);
    }

    @Override
    public User get(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public PagingDto<User> query(int pageNo, int pageSize, String name) throws Exception {
        StringSql jpql = new StringSql();
        List<Object> params = new ArrayList<>();

        if (name != null && !"".equals(name)) {
            jpql.add(" and name like ?");
            params.add("%" + name + "%");
        }

        return super.pagingQuickIdDesc(jpql.toString(), pageNo, pageSize, params.toArray());
    }

    @Override
    public List<User> findAll() throws Exception {
        return super.findQuickIdDesc("");
    }

    @Override
    public List<UserWithWalletDto> findAllUsersWithWallet() throws Exception {
        return super.execDql(
                "select new com.llw.demo.dto.UserWithWalletDto(u.id, u.name, w.money) from User u left join Wallet w on u.id=w.userId",
                UserWithWalletDto.class);
    }

}
