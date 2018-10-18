package com.util.supplier;


import com.exception.EntityNotFoundException;

import java.util.function.Supplier;
public class ExceptionSupplier {

    private ExceptionSupplier() {

    }

    public static Supplier<EntityNotFoundException> notFound(String entityName, String param) {
        return () -> new EntityNotFoundException(entityName, param);
    }

    public static Supplier<IllegalArgumentException> badContent(String message) {
        return () -> new IllegalArgumentException(message);
    }

    public static Supplier<UnsupportedOperationException> unsupportedOperation(String message) {
        return () -> new UnsupportedOperationException(message);
    }
}