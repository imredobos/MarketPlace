package com.imredobos.marketplace.service.exception;

public class InvalidSortDirectionException extends RuntimeException {
    public InvalidSortDirectionException(String direction) {
        super("Invalid sort direction: " + direction);
    }
}
