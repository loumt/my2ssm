package cn.mt.dao;

import cn.mt.models.User;
import cn.mt.vo.UserQueryVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname IUserDao
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/8 9:42
 */

public interface IUserDao {

    /**
     * 查询所有用户列表
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap", value = {
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "id", property = "accounts", many = @Many(select = "cn.mt.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Insert("insert into user(username,sex,address,birthday)values(#{username},#{sex},#{address},#{birthday})")
//    @SelectKey(keyProperty = "id", keyColumn = "id", before = false, statement = "select LAST_INSERT_ID()",resultType = Long.class)
    void saveUser(User user);

    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(Long id);

    @Select("select * from user where id=#{id}")
    User findUserById(Long id);

    @Select("select * from user where username like #{likename}")
    List<User> findLikeName(String likename);

    @Select("select count(id) from user")
    Integer findTotal();

    List<User> findUserByVo(UserQueryVo vo);

    List<User> findUserByCondition(User user);

    List<User> findUserByIds(UserQueryVo vo);
}
