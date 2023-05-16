package com.example.clonepjtairbb.stay.dto;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
public class SearchOptionRequest {
    private Map<String, Object> data = new HashMap<>();

    public SearchOptionRequest(Map<String, Object> data) {
        this.data = data;
    }
}
