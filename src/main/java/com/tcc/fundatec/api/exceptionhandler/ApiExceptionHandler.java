package com.tcc.fundatec.api.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorMessage errorMsg = this.buildResponseBody("Bad Request", "Validation failed", status, path)
                .errors(errors)
                .build();

        LOGGER.info("\n\nValidation failed.\n" + errorMsg.toString(), ex);
        return new ResponseEntity<>(errorMsg, headers, status);
    }

    private ErrorMessage.ErrorMessageBuilder buildResponseBody(String error, String message, HttpStatus status, String path) {
        return ErrorMessage.builder()
                .error(error)
                .status(status.value())
                .timestamp(new Date())
                .path(path)
                .message(message);
    }
}

