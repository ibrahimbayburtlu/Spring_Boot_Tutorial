package com.ibrahimbayburtlu.aopdemo.dao;

import com.ibrahimbayburtlu.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccaountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
