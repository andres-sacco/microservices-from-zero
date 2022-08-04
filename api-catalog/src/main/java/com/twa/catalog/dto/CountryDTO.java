package com.twa.catalog.dto;

import javax.validation.constraints.*;

public class CountryDTO {
    @Min(1)
    @NotNull
    private Long id;

    @Size(min = 3, max = 3)
    private String code;

    @NotBlank(message = "Description is mandatory")
    private String description;

    public CountryDTO() {

    }

    public CountryDTO(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
