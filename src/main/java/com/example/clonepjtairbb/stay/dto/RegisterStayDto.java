package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RegisterStayDto {
    private String stayTitle;
    private String stayContent;
    private CountryEnum country;
    private CityEnum city;
    private Integer costPerDay;
    private StayTypeEnum stayType;
    private Integer numBed;
    private BedTypeEnum bedType;
    private BathTypeEnum bathType;
    private Boolean isAlone;
    private Boolean isGuest;
    private List<String> imageUrlList;
    private DescTagEnum descTag;
    private Integer checkInBefore;
    private Integer checkOutAfter;
    private Integer maxGroupNum;

//    public RegisterStayDto(
//            String stayTitle, String stayContent, String country, String city, Integer costPerDay,
//            String stayType, Integer numBed, BedTypeEnum bedType, BathTypeEnum bathType, Boolean isAlone,
//            Boolean isGuest, List<String> imageUrlList, DescTagEnum descTag, Integer checkInBefore,
//            Integer checkOutAfter, Integer maxGroupNum
//    ) {
//        this.stayTitle = stayTitle;
//        this.stayContent = stayContent;
//        this.country = country;
//        this.city = city;
//        this.costPerDay = costPerDay;
//        this.stayType = stayType;
//        this.numBed = numBed;
//        this.bedType = bedType;
//        this.bathType = bathType;
//        this.isAlone = isAlone;
//        this.isGuest = isGuest;
//        this.imageUrlList = imageUrlList;
//        this.descTag = descTag;
//        this.checkInBefore = checkInBefore;
//        this.checkOutAfter = checkOutAfter;
//        this.maxGroupNum = maxGroupNum;
//    }
}
