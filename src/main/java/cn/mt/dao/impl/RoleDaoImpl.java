package cn.mt.dao.impl;

import cn.mt.dao.RoleDao;
import cn.mt.models.Role;
import cn.mt.utils.Page;
import org.springframework.stereotype.Repository;

/**
 * @Classname RoleDaoImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:42
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
    @Override
    public Page<Role> findByPage(int pageNo, int pageSize) {
        String sql = "select * from role";
        return super.queryPagination(sql,null,pageNo,pageSize, Role.class);
    }
}
