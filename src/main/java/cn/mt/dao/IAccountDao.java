package cn.mt.dao;

import cn.mt.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname IAccountDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description 账户Dao
 * @Date 2020/6/14 23:12
 */
@Repository("accountDao")
public interface IAccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(uid,balance)values(#{uid},#{balance})")
    void saveAccount(Account account);

}
