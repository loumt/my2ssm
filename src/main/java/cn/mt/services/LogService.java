package cn.mt.services;

import cn.mt.models.Log;
import cn.mt.utils.Page;

/**
 * @Classname LogService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 14:16
 */
public interface LogService {
    Page<Log> list(int pageNo,int pageSize);
}
