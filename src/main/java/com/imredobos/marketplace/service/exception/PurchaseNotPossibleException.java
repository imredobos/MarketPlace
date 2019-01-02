package com.imredobos.marketplace.service.exception;

public class PurchaseNotPossibleException extends RuntimeException {

    public PurchaseNotPossibleException(Long id) {
        super(String.format("Purchase not possible for product with id [%s]", id));
    }
}
