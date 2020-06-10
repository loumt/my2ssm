package cn.mt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Classname User
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:39
 */
@Setter
@Getter
@ToString
public class User {
    private Long id;
    private String username;
    private String sex;
    private String address;
    private Date birthday;
    private Date loginTime;
}
