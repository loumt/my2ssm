package cn.mt.dao;

import cn.mt.models.Account;
import cn.mt.models.AccountUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname IAccountDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/9 14:39
 */
public interface IAccountDao {

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "user", column = "uid",one =  @One(select = "cn.mt.dao.IUserDao.findUserById", fetchType = FetchType.LAZY))
    })
    List<Account> findAll();


    List<AccountUser> findAllAccount();

    @Select("select * from account where uid = #{uid}")
    @ResultMap("accountMap")
    Account findAccountByUid(Long uid);

}
