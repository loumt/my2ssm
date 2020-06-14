package cn.mt.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Classname LogAopAround
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/11 13:08
 */
public class LogAopAround {

    public void printBefore() {
        System.out.println(" =Before======== Action ========Before= ");
    }


    public void printReturning() {
        System.out.println(" =Return======== Action ========Return= ");
    }

    public void printThrowing() {
        System.out.println(" =Throwing======== Action ========Throwing= ");
    }

    public void printAfter() {
        System.out.println(" =After======== Action ========After= ");
    }


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
