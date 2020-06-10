package cn.mt.services.impl;

import cn.mt.dao.LogDao;
import cn.mt.models.Log;
import cn.mt.services.LogService;
import cn.mt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname LogServiceImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 14:42
 */
@Service
public class LogServiceImpl  implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public Page<Log> list(int pageNo, int pageSize) {
        return logDao.findByPage(pageNo,pageSize);
    }
}
