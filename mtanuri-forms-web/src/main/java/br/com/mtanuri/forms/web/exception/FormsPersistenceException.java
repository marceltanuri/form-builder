package br.com.mtanuri.forms.web.exception;

public class FormsPersistenceException extends FormsException{

    public FormsPersistenceException(String message) {
        super(message);
    }

    public FormsPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
