package br.com.mtanuri.forms.web.exception;

public abstract class FormsException extends Exception{

    public FormsException(String message) {
        super(message);
    }

    public FormsException(String message, Throwable cause) {
        super(message, cause);
    }
}
