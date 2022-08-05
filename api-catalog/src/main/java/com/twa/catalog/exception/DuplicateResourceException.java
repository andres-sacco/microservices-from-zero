package com.twa.catalog.exception;

import com.twa.catalog.enums.APIError;

public class DuplicateResourceException extends TWAException {

    public DuplicateResourceException(APIError error) {
        super(error.getHttpStatus(), error.getMessage(), null);
    }
}
