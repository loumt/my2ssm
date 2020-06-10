package cn.mt.dao.impl;

import cn.mt.dao.BaseDao;
import cn.mt.exception.DaoException;
import cn.mt.utils.Page;
import cn.mt.utils.SqlHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Classname BaseDaoImpl
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/5/30 21:34
 */
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name= "namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate npjt;

    @Resource(name = "mysqlSqlHandle")
    private SqlHandle sqlHandle;

    /**
     * 执行单条insert 语句 返回主键id
     *
     * @param sql    要执行的sql语句
     * @param object 语句中的参数
     * @return 执行语句影响数据的条数
     */
    protected long saveBean(String sql, Object object) throws DaoException{
        try {
            SqlParameterSource ps = new BeanPropertySqlParameterSource(object);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.npjt.update(sql, ps, keyHolder);
            long id = keyHolder.getKey().longValue();
            return id;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public Long count(String sql , Object[] params)  throws DaoException{
        try{
            Long count = jdbcTemplate.queryForObject(sql,Long.class, params);
            return count;
        }catch (Exception e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public <T> List<T> find(String sql, Object[] params, Class<T> tClass) {
        List<T> resultList = null;
        if (params != null && params.length >= 0) {
            resultList = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<T>(tClass));
        } else {
            resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(tClass));
        }
        return resultList;
    }

    @Override
    public <T> int addOrUpdateOrDelete(String sql, Object[] params, Class<T> tClass) {
        int num = 0;
        try {
            if (params == null || params.length == 0)
                num = jdbcTemplate.update(sql);
            else
                num = jdbcTemplate.update(sql, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        for (int i = 0; i < params.length; i++)
                            ps.setObject(i + 1, params[i]);
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
            num = -1;
        }
        return num;
    }

    @Override
    public <T> Page<T> queryPagination(String sql, Object[] parameters, int pageNo, int pageSize, Class<T> entity) {
        // 将SQL语句进行分页处理
        String newSql = sqlHandle.handlerPageSql(sql, pageNo, pageSize);
        List<T> list = null;
        List<T> totalList = null;
        if (parameters == null || parameters.length <= 0) {
            totalList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(entity));
            list = jdbcTemplate.query(newSql, new BeanPropertyRowMapper<T>(entity));
        } else {
            totalList = jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<T>(entity));
            list = jdbcTemplate.query(newSql, parameters, new BeanPropertyRowMapper<T>(entity));
        }
        // 根据参数的个数进行差别查询
        Page<T> page = new Page<T>(pageNo, pageSize, totalList.isEmpty() ? 0 : totalList.size(), list);
        return page;
    }

    @Override
    public <T> T findForObject(String sql, Object[] args, Class<T> classT) {
        if (sql == null || sql.length() <= 0) {
            return null;
        }
        if (args == null || args.length <= 0) {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(classT));
        }
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<T>(classT));
    }

    @Override
    public Map<String, Object> find(String sql, Object[] params) {
        return jdbcTemplate.queryForMap(sql, params);
    }

    @Override
    public List<Map<String, Object>> queryList(String sql, Object[] params) {
        return jdbcTemplate.queryForList(sql, params);
    }
}
