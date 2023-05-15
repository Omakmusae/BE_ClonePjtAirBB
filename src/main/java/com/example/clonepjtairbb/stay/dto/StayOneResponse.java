package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.BedTypeEnum;
import com.example.clonepjtairbb.common.enums.CityEnum;
import com.example.clonepjtairbb.common.enums.CountryEnum;
import com.example.clonepjtairbb.common.enums.StayTypeEnum;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.entity.StayDetailFeature;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StayOneResponse{
    private Long id;
    private String stayTitle;
    private String hostNickname;
    private CountryEnum country;
    private CityEnum city;
    private Integer costPerDay;
    private StayTypeEnum stayType;
    private Integer numBed;
    private BedTypeEnum bedType;
//    private BathTypeEnum bathType;
    private Boolean isGuest;
    private String thumbnailUrl;
    private String stayContent;
    private String descTag;
    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;

    public StayOneResponse(Stay stay) {
        this.id = stay.getId();
        this.stayTitle = stay.getTitle();
        this.hostNickname = stay.getHost().getNickname();
        this.country = stay.getCountry();
        this.city = stay.getCity();
        this.costPerDay = stay.getCostPerDay();
        this.stayType = stay.getStayType();

        StayDetailFeature detailFeature = stay.getStayDetailFeature();
        this.numBed = detailFeature.getNumBed();
        this.bedType = detailFeature.getBedType();
//        this.bathType = detailFeature.getBathType();
        this.isGuest = detailFeature.getIsAlone();
        this.thumbnailUrl = stay.getThumbnailURL();
        this.stayContent = stay.getContent();
        this.descTag = detailFeature.getDescTag().toString();
        this.checkInAfter = detailFeature.getCheckInAfter();
        this.checkOutBefore = detailFeature.getCheckOutBefore();
        this.maxGroupNum = detailFeature.getMaxGroupNum();
    }
}
