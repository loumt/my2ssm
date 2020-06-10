package cn.mt.services;

import cn.mt.exception.ServiceException;
import cn.mt.models.Role;
import cn.mt.models.User;
import cn.mt.utils.Page;

/**
 * @Classname UserService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
public interface UserService {
    Page<User> list(int pageNo, int pageSize);

    User findUserByUsername(String username);


    Long count(String name) throws ServiceException;

    Long createAccount(User user) throws ServiceException;
}
