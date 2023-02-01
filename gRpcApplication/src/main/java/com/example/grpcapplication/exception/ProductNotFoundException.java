package com.example.grpcapplication.exception;

import io.grpc.Status;

public class ProductNotFoundException extends BaseBusinessException {

    private static final String ERROR_MESSAGE = "Product com ID %s nao encontrado.";
    private final Long id;

    public ProductNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    @Override
    public Status getStatusCode() {
        return Status.NOT_FOUND;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE, this.id);
    }
}
