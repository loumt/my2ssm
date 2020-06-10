package cn.mt.services;

import cn.mt.models.Log;
import cn.mt.models.Role;
import cn.mt.utils.Page;

/**
 * @Classname RoleService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
public interface RoleService {
    Page<Role> list(int pageNo, int pageSize);
}
