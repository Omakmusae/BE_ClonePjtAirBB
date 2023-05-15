package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.CityEnum;
import com.example.clonepjtairbb.common.enums.CountryEnum;
import com.example.clonepjtairbb.common.enums.StayTypeEnum;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StayOneResponse{
    private Long id;
    private User host;
    private String title;
    private String content;
    private String thumbnailURL;
    private CountryEnum country;
    private CityEnum city;
    private Integer costPerDay;
    private StayTypeEnum stayType;


    public StayOneResponse(Stay stay) {
        this.id = stay.getId();
        this.host = stay.getHost();
        this.title = stay.getTitle();
        this.content = stay.getContent();
        this.thumbnailURL = stay.getThumbnailURL();
        this.country = stay.getCountry();
        this.city = stay.getCity();
        this.costPerDay = stay.getCostPerDay();
        this.stayType = stay.getStayType();
    }
}
