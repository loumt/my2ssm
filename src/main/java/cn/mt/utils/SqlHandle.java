package cn.mt.utils;

/**
 * @Classname SqlHandle
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description Sql分页处理器
 * @Date 2020/5/30 20:37
 */
public interface SqlHandle {

    /**
     * 处理分页SQL函数
     * @param sql 原sql
     * @param pageNo 页码
     * @param pageSize 每页大小
     * @return
     */
    String handlerPageSql(String sql, int pageNo, int pageSize);

}
