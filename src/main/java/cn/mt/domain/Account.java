package cn.mt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Classname Account
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/14 23:10
 */
@Setter
@Getter
@ToString
public class Account implements Serializable {
    private static final long serialVersionUID = 6473845657529673523L;

    private Long id;
    private Long uid;
    private Double balance;
}
