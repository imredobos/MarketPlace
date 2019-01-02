package com.imredobos.marketplace.service.exception;

public class SellerNotFoundException extends RuntimeException {

    public SellerNotFoundException(Long id) {
        super(String.format("Seller with id [%s] not found.", id));
    }
}
