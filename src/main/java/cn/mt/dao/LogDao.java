package cn.mt.dao;

import cn.mt.models.Log;
import cn.mt.utils.Page;

/**
 * @Classname LogDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/5/30 22:04
 */
public interface LogDao {
    Page<Log> findByPage(int pageNo,int pageSize);
}
