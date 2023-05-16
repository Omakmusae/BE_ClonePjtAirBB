package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.*;
import lombok.Data;
import lombok.Getter;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SearchOptionRequest {

//    private Map<String, Object> data = new HashMap<>();
    private String country;             // 나라
    private String city;                // 도시
    private String cost_min;            // 최소값
    private String cost_max;            // 최댓값
    private String stayType;            // 주거형식

    // Details
    private String numBed;             // 침대갯수
    private String bedType;        // 침대타입
    private String isShared;            // 쉐어여부
    private String descTag;        // 숙소에 대한 설명 태그
    private String checkin_date;        //체크인 요청 날짜
    private String checkout_date;       //체크아웃 요청 날짜
    private String groupsize;        // 숙박 인원수
    private List<String> convenience;

    public MappedSearchRequest toMappedSearchRequest(){
        return MappedSearchRequest.builder()
                .country(country == null ? null : CountryEnum.valueOf(country))
                .city(city == null ? null : CityEnum.valueOf(city))
                .cost_min(cost_min == null ? null : Integer.valueOf(cost_min))
                .cost_max(cost_max == null ? null : Integer.valueOf(cost_max))
                .stayType(stayType == null ? null : StayTypeEnum.valueOf(stayType))
                .numBed(numBed == null ? null : Integer.valueOf(numBed))
                .bedType(bedType == null ? null : BedTypeEnum.valueOf(bedType))
                .isShared(isShared == null ? null : isShared.equals("true"))
                .descTag(descTag == null ? null : DescTagEnum.valueOf(descTag))
                .checkin_date(checkin_date == null ? null : stringToCalendar(checkin_date))
                .checkout_date(checkout_date == null ? null : stringToCalendar(checkout_date))
                .groupsize(groupsize == null ? null : Integer.valueOf(groupsize))
                .convenience(convenience == null ? null : convenience.stream().map(ConvenienceEnum::valueOf).toList())
                .build();
    }

    //2023-05-13 형식을 calendar로 바꿔줌
    private Calendar stringToCalendar(String stringDate) {
        String[] splitString = stringDate.split("-");
        DateDto date = new DateDto(
                Integer.valueOf(splitString[0]), Integer.valueOf(splitString[1]), Integer.valueOf(splitString[2])
        );
        return date.toCalendar();
    }
}
