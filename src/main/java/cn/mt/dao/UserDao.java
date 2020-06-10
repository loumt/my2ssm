package cn.mt.dao;

import cn.mt.exception.DaoException;
import cn.mt.models.Log;
import cn.mt.models.User;
import cn.mt.utils.Page;

/**
 * @Classname UserDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
public interface UserDao {
    Page<User> findByPage(int pageNo, int pageSize);

    User findUserByName(String username);

    Long count(String name) throws DaoException;

    Long save(User user) throws DaoException;
}
