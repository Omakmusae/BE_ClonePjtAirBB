package com.example.clonepjtairbb.stay.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StayListResponseDto {
    private String country;
    private String city;
    private String hostNickname;
    private Integer costPerDay;
    private String stayType;
    private String thumbnailUrl;
}
