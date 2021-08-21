package com.digitalexperts.authService.controllers;

import com.digitalexperts.authService.bo.CustomError;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class AuthServiceExceptionHandler {

   // private final Logger log = LoggerFactory.getLogger(AuthServiceExceptionHandler.class);


    @ExceptionHandler({UserExceptions.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomError> handleException(Exception ex, HttpServletRequest request) {

        CustomError errors = new CustomError();
        errors.setErrorMessage(ex.getMessage());
        errors.setTimestamp(new Date().toString());
        errors.setRequestPath(request.getRequestURI());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
/*

    @ExceptionHandler({RemoteApiConnectionExceptions.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<CustomError> handleRemoteServiceExceptions(Exception ex, HttpServletRequest request) {

        log.info("Caught RemoteApiConnectionExceptions : {}",ex);

        CustomError errors = new CustomError();
        errors.setErrorMessage(ex.getMessage());
        errors.setTimestamp(new Date().toString());
        errors.setRequestPath(request.getRequestURI());
        return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomError> handleSQLIntegrityConstraintViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {

        log.info("Caught DataIntegrityViolationException... {}",ex.getCause());
        CustomError errors = new CustomError();
        errors.setErrorMessage("Veuiller revoir les données saisies,un ou plusieurs champs saisies ne correspondent pas aux type(s) de données attendues.");
        errors.setTimestamp(new Date().toString());
        errors.setRequestPath(request.getRequestURI());
        return new ResponseEntity<CustomError>(errors, HttpStatus.BAD_REQUEST);
    }
*/

}
