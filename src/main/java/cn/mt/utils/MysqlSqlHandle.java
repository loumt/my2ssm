package cn.mt.utils;

import org.springframework.context.annotation.Bean;

/**
 * @Classname MysqlSqlHandle
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description Mysql Sql分页处理器
 * @Date 2020/5/30 20:40
 */
public class MysqlSqlHandle implements SqlHandle{
    @Override
    public String handlerPageSql(String sql, int pageNo, int pageSize) {
        StringBuffer originSql = new StringBuffer(sql);
        if(pageSize > 0) {
             int first = (pageNo -1 ) * pageSize;
             if(first <= 0) {
                 originSql.append(" limit ").append(pageSize);
             }else{
                 originSql.append(" limit ").append(first).append(",").append(pageSize);
             }
        }
        return originSql.toString();
    }
}
