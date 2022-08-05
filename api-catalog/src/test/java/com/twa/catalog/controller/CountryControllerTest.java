package com.twa.catalog.controller;

import com.twa.catalog.dto.CountryDTO;
import com.twa.catalog.service.CountryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryControllerTest {

    private CountryController controller;
    private CountryService service;

    @BeforeEach
    public void setup() {
        service = mock(CountryService.class);
        controller = new CountryController(service);
    }

    @Test
    public void should_get_one_country() {
        Long countryId = 1L;
        when(service.get(countryId)).thenReturn(new CountryDTO(countryId, "tes", "test"));

        ResponseEntity<CountryDTO> responseEntity = controller.get(countryId);

        assertAll(
                ()-> assertNotNull(responseEntity),
                () -> assertEquals(countryId, responseEntity.getBody().getId()),
                () -> assertEquals("tes", responseEntity.getBody().getCode()),
                () -> assertEquals("test", responseEntity.getBody().getDescription())
        );
    }


    @Test
    public void should_delete_one_country() {
        Long countryId = 1L;
        ResponseEntity<Void> responseEntity = controller.delete(countryId);

        assertAll(
                ()-> assertNotNull(responseEntity)
        );
    }
}
