import cn.mt.dao.IRoleDao;
import cn.mt.dao.IUserDao;
import cn.mt.models.Role;
import cn.mt.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname RoleTest
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/10 14:02
 */
public class RoleTest {


    private SqlSession sqlSession;
    private InputStream in;
    IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();

        roleDao = sqlSession.getMapper(IRoleDao.class);
    }


    @After
    public void destory() throws IOException {
        //事务的提交
        sqlSession.commit();

        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll(){

        List<Role> all = roleDao.findAll();
        for (Role role: all){
            System.out.println(role);
        }
    }

    @Test
    public void findById(){

        Role role = roleDao.findRoleById(1L);
        System.out.println(role);
    }

}
