package cn.mt.services.impl;

import cn.mt.services.AccountService;

/**
 * @Classname AccountServiceImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/12 11:12
 */
public class AccountServiceImpl implements AccountService{

    @Override
    public void in(float in) {
        System.out.println(" In == " + in);
        int i = 1/0;
    }

    @Override
    public void out(float out) {
        System.out.println(" Out == " + out);
    }

    @Override
    public boolean transfer(float money, String name) {
        System.out.println(" Transfer == " + money + " To " + name);
        return true;
    }
}
