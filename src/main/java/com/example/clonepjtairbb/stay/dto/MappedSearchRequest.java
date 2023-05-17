package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Calendar;
import java.util.List;

@Getter
public class MappedSearchRequest {
    private CountryEnum country;             // 나라
    private CityEnum city;                // 도시
    private Integer cost_min;            // 최소값
    private Integer cost_max;            // 최댓값
    private StayTypeEnum stayType;            // 주거형식

    // Details
    private Integer numBed;             // 침대갯수

    private BedTypeEnum bedType;        // 침대타입

    private Boolean isShared;            // 쉐어여부
    private DescTagEnum descTag;        // 숙소에 대한 설명 태그
    private Calendar checkin_date;        //체크인 요청 날짜
    private Calendar checkout_date;       //체크아웃 요청 날짜
    private Integer groupsize;        // 숙박 인원수
    private List<String> convenience;

    @Builder
    public MappedSearchRequest(CountryEnum country, CityEnum city, Integer cost_min, Integer cost_max,
                               StayTypeEnum stayType, Integer numBed, BedTypeEnum bedType, Boolean isShared,
                               DescTagEnum descTag, Calendar checkin_date, Calendar checkout_date, Integer groupsize,
                               List<String> convenience) {
        this.country = country;
        this.city = city;
        this.cost_min = cost_min;
        this.cost_max = cost_max;
        this.stayType = stayType;
        this.numBed = numBed;
        this.bedType = bedType;
        this.isShared = isShared;
        this.descTag = descTag;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.groupsize = groupsize;
        this.convenience = convenience;
    }
}
