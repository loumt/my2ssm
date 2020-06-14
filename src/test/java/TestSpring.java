import cn.mt.service.impl.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname TestSpring
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/14 23:25
 */
public class TestSpring {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-init.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);

        accountService.getAllAccount();


    }


}
