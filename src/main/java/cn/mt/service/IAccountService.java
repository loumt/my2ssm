package cn.mt.service;

import cn.mt.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname IAccountService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/14 23:14
 */
public interface IAccountService {
    List<Account> getAllAccount();
    void saveAccount(Account account);
}
