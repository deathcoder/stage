package it.objectway.warehouse.exception;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class CsvFormatException extends RuntimeException {
    public CsvFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
