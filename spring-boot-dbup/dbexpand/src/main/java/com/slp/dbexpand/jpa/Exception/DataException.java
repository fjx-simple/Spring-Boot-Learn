package com.slp.dbexpand.jpa.Exception;

/**
 * Created by sangliping on 2017/9/1.
 */
public class DataException  extends RuntimeException{

    public  int code;
    public final static int noPermission = -100;
    public final static int noID = -1;

    public DataException(int code) {
        this.code = code;
    }

    public DataException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DataException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public DataException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public DataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
