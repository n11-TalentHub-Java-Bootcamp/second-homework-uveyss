package com.example.exceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest webRequest)
    {
        Date errorDate = new Date();
        String message= exception.getMessage();
        String description=webRequest.getDescription(false);
        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllException(ProductNotFoundException productNotFoundException,WebRequest webRequest)
    {
        Date errorDate = new Date();
        String message = productNotFoundException.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Date errorDate = new Date();
        String message = "Validation failed!";
        String description = ex.getBindingResult().toString();

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
