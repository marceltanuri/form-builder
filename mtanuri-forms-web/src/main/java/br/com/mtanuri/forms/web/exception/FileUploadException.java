package br.com.mtanuri.forms.web.exception;

public class FileUploadException extends FormsException {

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
