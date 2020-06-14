package cn.mt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Classname MonitorAop
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/12 12:37
 */
@Component("monitorAop")
@Aspect
public class MonitorAop {

    @Pointcut("execution(* cn.mt.services.impl.AccountServiceImpl.*(..))")
    private void pointCut(){};

    @Before("pointCut()")
    public void printBefore() {
        System.out.println(" =Before======== Action ========Before= ");
    }

    @AfterReturning("pointCut()")
    public void printReturning() {
        System.out.println(" =Return======== Action ========Return= ");
    }

    @AfterThrowing("pointCut()")
    public void printThrowing() {
        System.out.println(" =Throwing======== Action ========Throwing= ");
    }

    @After("pointCut()")
    public void printAfter() {
        System.out.println(" =After======== Action ========After= ");
    }


    @Around("pointCut()")
    public Object printAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println(" =Before======== Action ========Before= ");
            //执行
            Object o = proceedingJoinPoint.proceed(args);
            System.out.println(" =Return======== Action ========Return= ");
            return o;
        } catch (Throwable e) {
            System.out.println(" =Thrown======== Action ========Thrown= ");
            throw new RuntimeException(e);
        }finally {
            System.out.println(" =After======== Action ========After= ");
        }
    }

}
