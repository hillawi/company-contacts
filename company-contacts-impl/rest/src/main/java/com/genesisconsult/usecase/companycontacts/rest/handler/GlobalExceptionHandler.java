package com.genesisconsult.usecase.companycontacts.rest.handler;

import com.genesisconsult.usecase.companycontacts.core.exception.EntityAlreadyExistsException;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityNotFoundException;
import com.genesisconsult.usecase.companycontacts.core.exception.InvalidEntityException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String BASE_URL = "https://genesis-consult.com/demo/company-contacts/problems";

    @ExceptionHandler(EntityNotFoundException.class)
    ProblemDetail handleEntityNotFoundException(EntityNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Entity not found");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(URI.create(BASE_URL + "/not-found"));
        return problemDetail;
    }

    @ExceptionHandler(InvalidEntityException.class)
    ProblemDetail handleInvalidEntityException(InvalidEntityException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Entity not valid");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(URI.create(BASE_URL + "/bad-request"));
        return problemDetail;
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    ProblemDetail handleEntityAlreadyExistsException(EntityAlreadyExistsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problemDetail.setTitle("Entity already exists");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(URI.create(BASE_URL + "/conflict"));
        return problemDetail;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ProblemDetail handleConstraintViolationException(ConstraintViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Entity not valid");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(URI.create(BASE_URL + "/bad-request"));
        return problemDetail;
    }
}
