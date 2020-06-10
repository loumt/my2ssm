package cn.mt.dao;

import cn.mt.models.Log;
import cn.mt.models.Role;
import cn.mt.utils.Page;

/**
 * @Classname RoleDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
public interface RoleDao {
    Page<Role> findByPage(int pageNo, int pageSize);
}
