package com.sofency.top.nuxtblog.handler;

import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.exception.SessionTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLDataException;
import java.util.Map;

/**
 * <p>Project: nuxt-blog - ExceptionHandler
 * <p>Powered by echo On 2024-03-16 21:03:59
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SessionTimeoutException.class)
    public ResponseEntity<Object> handleSessionTimeoutException(SessionTimeoutException e) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                .body(Map.of("message", e.getErrorMessage()));
    }

    @ExceptionHandler(SQLDataException.class)
    public ResponseEntity<Object> handleSQLDataException(SQLDataException sql) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", sql.getMessage()));
    }
}
