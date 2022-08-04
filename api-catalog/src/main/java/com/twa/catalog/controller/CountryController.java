package com.twa.catalog.controller;

import com.twa.catalog.dto.CountryDTO;
import com.twa.catalog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> get(@PathVariable Long id) {

        CountryDTO response = countryService.get(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country) {

        CountryDTO response = countryService.save(country);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO country) {

        CountryDTO response = countryService.update(id, country);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {

        countryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
