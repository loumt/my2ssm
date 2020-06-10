package cn.mt.dao.impl;

import cn.mt.dao.UserDao;
import cn.mt.exception.DaoException;
import cn.mt.models.User;
import cn.mt.utils.Page;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDaoImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        String sql = "select * from user";
        return super.queryPagination(sql, null, pageNo, pageSize, User.class);
    }

    @Override
    public User findUserByName(String username) {
        return null;
    }

    @Override
    public Long count(String name) throws DaoException {
        Object[] args = {name};
        String sql = "select count(*) from user where username = ?";
        return super.count(sql, args);
    }

    @Override
    public Long save(User user) throws DaoException {
        String sql = "insert into user(username,password,create_time)values(:username,:password,:createTime)";
        return super.saveBean(sql,user);
    }


}
