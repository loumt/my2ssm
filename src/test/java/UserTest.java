

import cn.mt.dao.IUserDao;
import cn.mt.models.User;
import cn.mt.vo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.QuadCurve2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1.读取配置文件
 * 2.创建SqlSessionFactory工厂
 * 3.使用工厂生产SqlSession对象
 * 4.使用SqlSession创建Dao接口的代理对象
 * 5.使用代理对象执行方法
 * 6.释放资源
 */
public class UserTest {

    private SqlSession sqlSession;
    private InputStream in;
    IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();

        userDao = sqlSession.getMapper(IUserDao.class);
    }


    @After
    public void destory() throws IOException {
        //事务的提交
        sqlSession.commit();

        sqlSession.close();
        in.close();
    }


    @Test
    public void findAll() throws IOException {
        
        List<User> all = userDao.findAll();
        for (User user: all){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    @Test
    public void saveUser(){
        
        User u = new User();
        u.setUsername("Your");
        u.setBirthday(new Date());
        u.setSex("男");
        u.setAddress("伦敦");
        u.setLoginTime(new Date());
        userDao.saveUser(u);
        System.out.println(u);
    }

    @Test
    public void updateUser(){
        
        User u = new User();
        u.setId(17L);
        u.setUsername("JION");
        u.setBirthday(new Date());
        u.setSex("男");
        u.setAddress("1111");
        userDao.updateUser(u);
    }


    @Test
    public void deleteUser(){
        
        userDao.deleteById(15L);
    }

    @Test
    public void findById(){
        
        User user = userDao.findUserById(18L);
        System.out.println(user);
    }


    @Test
    public void findTotal(){
        
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
    
    @Test
    public void findUserByQueryVo(){
        User u2 = new User();
        u2.setUsername("%M%");
        UserQueryVo vo = new UserQueryVo();
        vo.setUser(u2);
        List<User> all = userDao.findUserByVo(vo);
        for (User user: all){
            System.out.println(user);
        }
    }

    @Test
    public void  findUserByCondition(){
        User u2 = new User();
//        u2.setUsername("Mike");
        u2.setSex("女");

        List<User> all = userDao.findUserByCondition(u2);
        for (User user: all){
            System.out.println(user);
        }
    }

    @Test
    public void  findByIds(){
        List<Long> ids = new ArrayList<>();
        UserQueryVo vo = new UserQueryVo();
        ids.add(10L);
        ids.add(11L);
        ids.add(12L);
        ids.add(13L);
        ids.add(14L);
        vo.setIds(ids);
        List<User> all = userDao.findUserByIds(vo);
        for (User user: all){
            System.out.println(user);
        }
    }



    @Test
    public void findLikeName() throws IOException {
        List<User> all = userDao.findLikeName("%J%");
        for (User user: all){
            System.out.println(user);
        }
    }

}
