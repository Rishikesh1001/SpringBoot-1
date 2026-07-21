package com.rishikesh.demo.StudentServer.Exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(RuntimeException.class )
    public ResponseEntity<String> handleRuntimeExecutionException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

    }
    // 3. Handles CHECKED exceptions (like file system errors or network dropouts)
    @ExceptionHandler({IOException.class, Exception.class})
    public ResponseEntity<String> handleCheckedAndGeneralExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Checked Exception Triggered: " + e.getMessage());
    }

}
