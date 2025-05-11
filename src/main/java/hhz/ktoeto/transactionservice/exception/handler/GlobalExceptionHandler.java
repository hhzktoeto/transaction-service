package hhz.ktoeto.transactionservice.exception.handler;

import hhz.ktoeto.transactionservice.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_TEMPLATE = "Exception {}: {}";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException e) {
        logException(e);
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();
    }

    private void logException(Exception ex) {
        log.error(LOG_TEMPLATE, ex.getClass().getCanonicalName(), ex.getMessage());
        log.trace("Stack trace:", ex);
    }
}
