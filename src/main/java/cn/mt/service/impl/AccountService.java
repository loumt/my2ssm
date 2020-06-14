package cn.mt.service.impl;

import cn.mt.dao.IAccountDao;
import cn.mt.domain.Account;
import cn.mt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname AccountService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/14 23:15
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> getAllAccount() {
        System.out.println("查询所有的账户信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("保存账户信息");
        accountDao.saveAccount(account);
    }
}
