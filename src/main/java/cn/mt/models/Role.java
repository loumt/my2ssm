package cn.mt.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Classname Role
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 16:39
 */
@Setter
@Getter
public class Role {
    private Long id;
    private String name;
    private Date createTime;
}
