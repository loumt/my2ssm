package cn.mt.exception;

/**
 * @Classname ServiceExption
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 18:41
 */
public class ServiceException extends Exception{
    private static final long serialVersionUID = 8435931369436303696L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
