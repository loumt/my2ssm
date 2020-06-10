import cn.mt.dao.IAccountDao;
import cn.mt.dao.IUserDao;
import cn.mt.models.Account;
import cn.mt.models.AccountUser;
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
 * @Classname AccountTest
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/9 14:40
 */
public class AccountTest {

    private SqlSession sqlSession;
    private InputStream in;
    IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();

        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> all = accountDao.findAll();
        for (Account account: all){
            System.out.println("---------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findAllAccount() throws IOException {
        List<AccountUser> all = accountDao.findAllAccount();
        for (AccountUser account: all){
            System.out.println(account);
        }
    }
}
