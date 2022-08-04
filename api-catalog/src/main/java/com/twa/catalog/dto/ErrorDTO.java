package com.twa.catalog.dto;

import java.util.List;

public class ErrorDTO {
    private String description;
    private List<String> reasons;

    public ErrorDTO(String description, List<String> reasons) {
        this.description = description;
        this.reasons = reasons;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getReasons() {
        return reasons;
    }
}
