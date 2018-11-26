package com.llw.demo.service.impl;

import com.llw.demo.dao.IWalletDao;
import com.llw.demo.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @description:
* @author: liliwen
* @date: 2018-11-24
*/
@Transactional
@Service
public class IWalletServiceImpl implements IWalletService {

    @Autowired
    private IWalletDao walletDao;

}