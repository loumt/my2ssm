package cn.mt.utils;

/**
 * @Classname Page
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description Response Body 分装枚举
 * @Date 2020/5/30 19:49
 */
public enum ResultEnum {
    //基本错误
    SUCCESS(10000, "成功", true),
    FAILURE(10001,"失败",false),
    ILLEGAL(10002,"非法",false),
    EMPTY(10003,"数据为空",false),
    SYSTEM_ERROR(10004, "系统错误", false),

    //针对性错误
    USERNAME_EMPTY(20004, "用户名为空",false),
    PASSWORD_EMPTY(20005, "密码为空",false),
    EXIST(20006, "用户已存在", false)

    ;

    private Integer code;
    private String message;
    private Boolean isSuccess;

    ResultEnum(Integer code, String message, Boolean isSuccess) {
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}
