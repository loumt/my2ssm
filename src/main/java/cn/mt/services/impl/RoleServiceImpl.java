package cn.mt.services.impl;

import cn.mt.dao.RoleDao;
import cn.mt.models.Role;
import cn.mt.services.RoleService;
import cn.mt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname RoleServiceImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:43
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Page<Role> list(int pageNo, int pageSize) {
        return roleDao.findByPage(pageNo,pageSize);
    }
}
