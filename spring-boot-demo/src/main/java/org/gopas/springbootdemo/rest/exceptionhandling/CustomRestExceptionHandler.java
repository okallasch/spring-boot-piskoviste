package org.gopas.springbootdemo.rest.exceptionhandling;

import org.gopas.springbootdemo.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomRestExceptionHandler {

    private static final UrlPathHelper URL_PATH_HELPER = new UrlPathHelper();

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException e,
                                                                    HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        apiError.setTimestamp(LocalDateTime.now()); // new Date()
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(e.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleException(Exception e, HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(e.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
