package com.imredobos.marketplace.controller.exceptionhandler;

import com.imredobos.marketplace.util.ExceptionResponse;
import com.imredobos.marketplace.service.exception.InvalidSortDirectionException;
import com.imredobos.marketplace.service.exception.PurchaseNotPossibleException;
import com.imredobos.marketplace.service.exception.ProductNotFoundException;
import com.imredobos.marketplace.service.exception.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public final ResponseEntity<Object> handleSellerNotFoundException(SellerNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PurchaseNotPossibleException.class)
    public final ResponseEntity<Object> handlePurchaseNotPossibleException(PurchaseNotPossibleException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidSortDirectionException.class)
    public final ResponseEntity<Object> handlePurchaseNotPossibleExInvalidSortDirectionException(InvalidSortDirectionException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
