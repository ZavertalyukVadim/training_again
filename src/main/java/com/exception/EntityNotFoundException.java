package com.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, String param) {
        super(String.format("Not found entity -> %s by param -> %s", entityName, param));
    }
}