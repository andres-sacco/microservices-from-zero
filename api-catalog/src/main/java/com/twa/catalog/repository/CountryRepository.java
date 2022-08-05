package com.twa.catalog.repository;

import com.twa.catalog.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findByCode(String code);
}
