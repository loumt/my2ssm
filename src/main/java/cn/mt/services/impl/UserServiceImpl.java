package cn.mt.services.impl;

import cn.mt.dao.UserDao;
import cn.mt.exception.DaoException;
import cn.mt.exception.ServiceException;
import cn.mt.models.Role;
import cn.mt.models.User;
import cn.mt.services.UserService;
import cn.mt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname UserServiceImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Page<User> list(int pageNo, int pageSize) {
        return userDao.findByPage(pageNo,pageSize);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public Long count(String name) throws ServiceException {
        try {
            return userDao.count(name);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Long createAccount(User user) throws ServiceException {
        try {
            Long userId = userDao.save(user);
            return userId;
        }catch (DaoException e) {
            throw  new ServiceException(e.getMessage(),e);
        }
    }
}
