import cn.mt.services.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname AopAnnotationTest
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/12 12:42
 */
public class AopAnnotationTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-an.xml");

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
