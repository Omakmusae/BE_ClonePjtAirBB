package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.*;
import com.example.clonepjtairbb.stay.entity.Convenience;
import com.example.clonepjtairbb.stay.entity.ImageUrl;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.entity.StayDetailFeature;
import com.example.clonepjtairbb.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class RegisterStayRequest {
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
    private List<String> convenienceList;
    private List<String> imageUrlList;
    private DescTagEnum descTag;
    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;

    public RegisterStayRequest(
            String stayTitle, String stayContent, String country, String city, Integer costPerDay,
            String stayType, Integer numBed, String bedType, String bathType, Boolean isAlone,
            Boolean isGuest,List<String> convenienceList, List<String> imageUrlList, String descTag,
            Integer checkInAfter, Integer checkOutBefore, Integer maxGroupNum
    ) {
        this.stayTitle = stayTitle;
        this.stayContent = stayContent;
        this.country = CountryEnum.valueOf(country);
        this.city = CityEnum.valueOf(city);
        this.costPerDay = costPerDay;
        this.stayType = StayTypeEnum.valueOf(stayType);
        this.numBed = numBed;
        this.bedType = BedTypeEnum.valueOf(bedType);
        this.bathType = BathTypeEnum.valueOf(bathType);
        this.isAlone = isAlone;
        this.isGuest = isGuest;
        this.convenienceList = convenienceList;
        this.imageUrlList = imageUrlList;
        this.descTag = DescTagEnum.valueOf(descTag);
        this.checkInAfter = checkInAfter;
        this.checkOutBefore = checkOutBefore;
        this.maxGroupNum = maxGroupNum;
    }

    public Stay toStayEntity(User user){
        return Stay.builder()
                .host(user)
                .title(this.stayTitle)
                .content(this.stayContent)
                .thumbnailURL(this.imageUrlList.get(0))
                .country(this.country)
                .city(this.city)
                .costPerDay(this.costPerDay)
                .stayType(this.stayType)
                .build();
        //        stay.setStayDetailFeature(toStayDetailFeatureEntity(stay));
    }
    public StayDetailFeature toStayDetailFeatureEntity(Stay stay){
        return StayDetailFeature.builder()
                .stay(stay)
                .numBed(this.numBed)
                .bedType(this.bedType)
                .isAlone(this.isAlone)
                .descTag(this.descTag)
                .checkInAfter(this.checkInAfter)
                .checkOutBefore(this.checkOutBefore)
                .maxGroupNum(this.maxGroupNum)
                .build();
    }

    public List<ImageUrl> toImageUrlList(StayDetailFeature stayDetailFeature){
        List<ImageUrl> returnList = new ArrayList<>();
        for(String img: this.imageUrlList){
            ImageUrl imgUrl = new ImageUrl(stayDetailFeature, img);
            stayDetailFeature.addImageUrl(imgUrl);
            returnList.add(imgUrl);
        }
        return returnList;
    }

    public List<Convenience> toConvenienceList(StayDetailFeature stayDetailFeature){
        List<Convenience> returnList = new ArrayList<>();
        for(String convString:this.convenienceList){
            Convenience convenience = new Convenience(stayDetailFeature, ConvenienceEnum.valueOf(convString));
            stayDetailFeature.addConvenience(convenience);
            returnList.add(convenience);
        }
        return returnList;
    }
}
