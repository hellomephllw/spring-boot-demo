package com.llw.demo.dao.impl;

import com.happy.base.BaseJpaDao;
import com.happy.dto.po.PagingPo;
import com.happy.util.CollectionUtil;
import com.happy.util.StringUtil;
import com.llw.demo.dao.IUserDao;
import com.llw.demo.entity.User;
import com.happy.dto.PagingDto;
import com.happy.util.StringSql;
import com.llw.demo.transfer.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

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

    @Override
    public List<UserDto> findByNameAndAge(String name, int age) throws Exception {
        return super.express(
                "select * from @User where name=:name and age=:age",
                UserDto.class,
                CollectionUtil.fieldMap()
                        .put("name", name)
                        .put("age", age)
                        .build());
    }

    @Override
    public PagingPo<UserDto> queryForDto(int pageNo, int pageSize, String name, String nickname, Integer age, String detailAddress) throws Exception {
        StringBuilder sql = new StringBuilder("select * from @User where 1=1");
        Map<String, Object> params = new HashMap<>();

        if (!StringUtils.isEmpty(name)) {
            sql.append(" and name=:name");
            params.put("name", name);
        }
        if (!StringUtils.isEmpty(nickname)) {
            sql.append(" and nickname=:nickname");
            params.put("nickname", nickname);
        }
        if (age != null) {
            sql.append(" and age=:age");
            params.put("age", age);
        }
        if (!StringUtils.isEmpty(detailAddress)) {
            sql.append(" and detailAddress=:detailAddress");
            params.put("detailAddress", detailAddress);
        }

        return super.expressPagingMap(sql.toString(), UserDto.class, pageNo, pageSize, params);
    }
}
