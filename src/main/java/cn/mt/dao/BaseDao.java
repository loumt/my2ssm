package cn.mt.dao;

import cn.mt.exception.DaoException;
import cn.mt.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @Classname BaseDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/5/30 21:33
 */
public interface BaseDao {

     Long count(String sql , Object[] params)  throws DaoException;

     <T> List<T> find(String sql, Object[] params, Class<T> tClass);

     <T> int addOrUpdateOrDelete(String sql, Object[] params, Class<T> tClass);

     <T> Page<T> queryPagination(String sql, Object[] parameters, int pageNo, int pageSize, Class<T> entity);

     <T> T findForObject(String sql, Object[] args, Class<T> classT);

     Map<String, Object> find(String sql, Object[] params);

     List<Map<String, Object>> queryList(String sql, Object[] params);

}
