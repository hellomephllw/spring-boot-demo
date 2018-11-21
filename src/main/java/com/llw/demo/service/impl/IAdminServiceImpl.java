package com.llw.demo.service.impl;

import com.llw.demo.entity.Admin;
import com.llw.demo.service.IAdminService;
import com.llw.dto.PagingDto;
import com.llw.exception.BussinessException;
import com.llw.util.CollectionUtil;
import com.llw.util.DateUtil;
import com.llw.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @discription:
 * @author: llw
 * @date: 2018-11-15
 */
@Transactional
@Service
public class IAdminServiceImpl implements IAdminService {

    @Override
    public Admin login(String account, String password) throws Exception {
        return null;
    }

    @Override
    public PagingDto query(int pageNo, int pageSize, String name, Boolean active, Date createTime) throws Exception {
        if (pageNo < 1) throw new BussinessException("当前页码必须大于0");
        if (pageSize < 1) throw new BussinessException("每页数据量必须大于0");



        return null;
    }
}
