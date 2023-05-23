package com.example.orderbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionTranslator {

    @ExceptionHandler(ParsingException.class)
    public ResponseEntity<ErrorResponse> handleParsingException(ParsingException e) {
        String msg = "Malformed JSON request";
        return new ResponseEntity<>(new ErrorResponse(msg), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> handleInternalException(InternalServerException e) {
        String msg = "Something went wrong!";
        return new ResponseEntity<>(new ErrorResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
