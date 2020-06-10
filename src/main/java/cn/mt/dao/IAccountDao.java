package cn.mt.dao;

import cn.mt.models.Account;
import cn.mt.models.AccountUser;

import java.util.List;

/**
 * @Classname IAccountDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/9 14:39
 */
public interface IAccountDao {

    /**
     * 查询所有用户
     * @return
     */
    List<Account> findAll();


    List<AccountUser> findAllAccount();

}
