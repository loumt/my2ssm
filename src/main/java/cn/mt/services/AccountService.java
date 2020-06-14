package cn.mt.services;

/**
 * @Classname AccountService
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/12 11:12
 */
public interface AccountService {

    void in(float in);
    void out(float out);
    boolean transfer(float money, String name);

}
