package com.twa.catalog.service;

import com.twa.catalog.domain.Country;
import com.twa.catalog.dto.CountryDTO;
import com.twa.catalog.enums.APIError;
import com.twa.catalog.exception.DuplicateResourceException;
import com.twa.catalog.exception.ResourceNotException;
import com.twa.catalog.repository.CountryRepository;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private static Logger logger = LoggerFactory.getLogger(CountryService.class);

    private CountryRepository countryRepository;
    private MapperFacade mapperFacade;

    @Autowired
    public CountryService(CountryRepository countryRepository, MapperFacade mapperFacade) {
        this.countryRepository = countryRepository;
        this.mapperFacade = mapperFacade;
    }

    public CountryDTO get(Long id) {

        Optional<Country> country = countryRepository.findById(id);

        if(country.isEmpty()) {
            logger.debug("Not exist country with id: {}", id);
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }

        return mapperFacade.map(country.get(), CountryDTO.class);
    }

    public CountryDTO save(CountryDTO country) {
        Optional<Country> existCountry = countryRepository.findByCode(country.getCode());

        if(existCountry.isPresent()) {
            throw new DuplicateResourceException(APIError.COUNTRY_WITH_SAME_CODE);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(country, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public CountryDTO update(Long id, CountryDTO country) {
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            logger.info("Obtain information of the country with id: {}", id);
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(country, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public void delete(Long id) {
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }
        countryRepository.deleteById(id);
    }
}
