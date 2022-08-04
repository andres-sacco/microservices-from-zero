package com.twa.catalog.exception;

import com.twa.catalog.enums.APIError;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResourceNotException extends TWAException {

    public ResourceNotException(APIError error) {
        super(error.getHttpStatus(), error.getMessage(), null);
    }
}
