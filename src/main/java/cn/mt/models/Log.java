package cn.mt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Log implements Serializable{
    private static final long serialVersionUID = 2771373535981247839L;
    private Long id;
    private String username;
    private Date time;
}
