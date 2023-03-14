package com.axelate.staticdata.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerAdviceExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Problem> handleNotFoundException(NotFoundException ex) {
        Problem problem = Problem.builder()
                .withTitle(Status.NOT_FOUND.getReasonPhrase())
                .withDetail(ex.getMessage())
                .withStatus(Status.NOT_FOUND)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(problem);
    }


}
