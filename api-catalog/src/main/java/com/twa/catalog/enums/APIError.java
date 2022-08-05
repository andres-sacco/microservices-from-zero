package com.twa.catalog.enums;

import org.springframework.http.HttpStatus;

public enum APIError {
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"The are attributes with wrong values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST,"The message not have a correct form"),
    COUNTRY_NOT_FOUND(HttpStatus.NOT_FOUND, "Country not found"),
    COUNTRY_WITH_SAME_CODE(HttpStatus.BAD_REQUEST, "There is a country with the same code");

    private final HttpStatus httpStatus;
    private final String message;

    APIError(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
