package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
import com.example.clonepjtairbb.stay.entity.Stay;

import java.util.List;

public interface StayRepositoryCustom {
    List<Stay> findBySearchOption(SearchOptionRequest request);
}
