package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
public class SearchOptionRequest {
//    private Map<String, Object> data = new HashMap<>();
    private String country;             // 나라
    private String city;                // 도시
    private Integer minCost;            // 최소값
    private Integer maxCost;            // 최댓값
    private String stayType;            // 주거형식

    // Details
    private Integer numBed;             // 침대갯수
    private BedTypeEnum bedType;        // 침대타입
    private BathTypeEnum bathType;      // 욕실타입
    private Boolean isAlone;            // 쉐어여부
    private DescTagEnum descTag;        // 숙소에 대한 설명 태그
    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;        // 최대 숙박 인원수
}
