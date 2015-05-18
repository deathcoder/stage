package it.objectway.corsi.fssurfer.exceptions;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(String message) {
        super(message);
    }

    public UnknownFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
