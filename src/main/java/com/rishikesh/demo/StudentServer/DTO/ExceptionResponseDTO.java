package com.rishikesh.demo.StudentServer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


    @Data
    @AllArgsConstructor
    public class ExceptionResponseDTO {
        private LocalDateTime timestamp;
        private int statusCode;
        private String message;
        private String error;
        private String path;

    }

