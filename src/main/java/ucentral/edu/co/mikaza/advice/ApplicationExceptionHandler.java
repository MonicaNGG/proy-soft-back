package ucentral.edu.co.mikaza.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.exception.UserException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    private static String ERROR = "error";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserException.class)
    public Map<String, String> handleUserException(UserException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put(ERROR, ex.getMessage());

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyException.class)
    public Map<String, String> handlePropertyException(PropertyException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put(ERROR, ex.getMessage());

        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAnyException(Exception ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put(ERROR, ex.getMessage());

        return errors;
    }
}
