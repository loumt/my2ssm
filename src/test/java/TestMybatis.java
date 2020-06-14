import cn.mt.dao.IAccountDao;
import cn.mt.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Classname TestMybatis
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/15 0:12
 */
public class TestMybatis {

    InputStream in;
    SqlSession sqlSession;

    @Before
    public void init()throws Exception{
        //加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

        sqlSession = build.openSession();

    }


    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void getAll() {
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> all = accountDao.findAll();
        for(Account account : all){
            System.out.println(account);
        }
    }

    @Test
    public void saveAccount() {
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);

        Account account = new Account();
        account.setBalance(11.5d);
        account.setUid(10L);
        accountDao.saveAccount(account);

    }
}
