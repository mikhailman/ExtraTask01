package by.htp.verishko.task1.service;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 9876543L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }

    public ServiceException(Exception e) {
        super(e);
    }
}