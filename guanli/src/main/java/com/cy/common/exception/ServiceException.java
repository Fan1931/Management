package com.cy.common.exception;

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 927536545324503594L;
    public ServiceException() {
        super();
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
