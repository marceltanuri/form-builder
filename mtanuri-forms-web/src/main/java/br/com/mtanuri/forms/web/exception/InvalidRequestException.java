package br.com.mtanuri.forms.web.exception;

public class InvalidRequestException extends FormsException {

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
