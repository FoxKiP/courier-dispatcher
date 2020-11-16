package ru.nazarov.restservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLNonTransientException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundException(NotFoundException e) {
        log.info(e.getMessage());
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String validationException(ValidationException e) {
        log.info(e.getMessage());
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SQLNonTransientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String uniqueIdException(SQLNonTransientException e) {
        log.info(e.getMessage());
        return "задание с таким номером уже существует";
    }
}
