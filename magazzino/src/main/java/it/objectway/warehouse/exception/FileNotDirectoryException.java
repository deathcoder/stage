package it.objectway.warehouse.exception;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class FileNotDirectoryException extends RuntimeException {
    public FileNotDirectoryException(String message) {
        super(message);
    }
}
