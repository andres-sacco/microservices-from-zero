package com.twa.catalog.service;

import com.twa.catalog.dto.CountryDTO;
import com.twa.catalog.enums.APIError;
import com.twa.catalog.exception.ResourceNotException;
import com.twa.catalog.exception.TWAException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {
    public CountryDTO get(Long id) {

        if(id != 1) {
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }

        return new CountryDTO(id, "TE", "This is a mock response");
    }

    public CountryDTO save(CountryDTO country) {
        return country;
    }

    public CountryDTO update(Long id, CountryDTO country) {
        return country;
    }

    public void delete(Long id) {
        //TODO REMOVE ENTITY
    }
}
