package cn.mt.dao.impl;

import cn.mt.dao.LogDao;
import cn.mt.models.Log;
import cn.mt.utils.Page;
import org.springframework.stereotype.Repository;

/**
 * @Classname LogDaoImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/5/30 22:04
 */
@Repository
public class LogDaoImpl extends BaseDaoImpl implements LogDao {
    @Override
    public Page<Log> findByPage(int pageNo,int pageSize) {
        String sql = "select * from log";
        return super.queryPagination(sql,null,pageNo,pageSize,Log.class);
    }
}
