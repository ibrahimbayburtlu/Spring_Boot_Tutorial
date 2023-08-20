package com.ibrahimbayburtlu.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccaountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
