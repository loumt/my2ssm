import cn.mt.services.AccountService;
import cn.mt.services.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Classname AccountTest
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/11 11:20
 */

public class AccountTest {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");

        AccountService as = (AccountService) ac.getBean("accountService");

        try{
            as.in(11F);
//            as.out(11F);
//            as.transfer(11F, "Loumt");
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
