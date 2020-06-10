package cn.mt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname Account
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/9 14:35
 */
@Setter
@Getter
@ToString
public class Account {
    private Long id;
    private Long uid;
    private Double balance;

    private User user;
}
