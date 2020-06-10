package cn.mt.exception;

/**
 * @Classname DaoException
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/5/30 21:39
 */
public class DaoException extends Exception{
    private static final long serialVersionUID = 4900440035934696242L;

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
