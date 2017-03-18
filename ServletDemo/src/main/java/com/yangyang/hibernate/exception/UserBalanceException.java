package com.yangyang.hibernate.exception;

/**
 * Created by syy on 2017/2/21.
 */
public class UserBalanceException extends RuntimeException {
    public UserBalanceException() {
        super();
    }

    public UserBalanceException(String message) {
        super(message);
    }

    public UserBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserBalanceException(Throwable cause) {
        super(cause);
    }

    protected UserBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
