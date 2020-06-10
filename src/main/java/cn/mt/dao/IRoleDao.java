package cn.mt.dao;

import cn.mt.models.Role;
import cn.mt.models.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname IRoleDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/10 14:02
 */
public interface IRoleDao {

    @Select("select * from role")
    @Results(id = "roleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime")
    })
    List<Role> findAll();


    @Select("select * from role where id=#{id}")
    @ResultMap("roleMap")
    Role findRoleById(Long id);
}
