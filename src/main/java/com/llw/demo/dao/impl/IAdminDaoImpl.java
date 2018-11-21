package com.llw.demo.dao.impl;

import com.llw.base.BaseJpaDao;
import com.llw.demo.dao.IAdminDao;
import com.llw.demo.dto.UserWithWalletDto;
import com.llw.demo.entity.Admin;
import com.llw.dto.PagingDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-16
 */
@Repository
public class IAdminDaoImpl extends BaseJpaDao<Admin> implements IAdminDao {

    @SuppressWarnings("unchecked")
    @Override
    public PagingDto query(int pageNo, int pageSize, String name) throws Exception {
        List<UserWithWalletDto> userDtoTypedQuery = entityManager.createQuery(
                "select new com.llw.demo.dto.UserWithWalletDto(u.id, u.name, w) from User u left join Wallet w on w.userId=u.id").getResultList();

        System.out.println(userDtoTypedQuery);

//        System.out.println(userDtos);
//        for (Object obj : userDtos) {
//            Object[] os = (Object[]) obj;
//            System.out.println("======");
//            for (Object o : os) {
//                System.out.println(o);
//            }
//        }

        return null;
    }

}
