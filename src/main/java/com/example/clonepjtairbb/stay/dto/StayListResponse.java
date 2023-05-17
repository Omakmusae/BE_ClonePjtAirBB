package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.stay.entity.Stay;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StayListResponse {
    private Long stayId;
    private String country;
    private String city;
    private String hostNickname;
    private Integer costPerDay;
    private String stayType;
    private String img;

    public StayListResponse(Stay stay) {
        this.stayId = stay.getId();
        this.country = stay.getCountry().toString();
        this.city = stay.getCity().toString();
        this.hostNickname = stay.getHost().getNickname();
        this.costPerDay = stay.getCostPerDay();
        this.stayType = stay.getStayType().toString();
        this.img = stay.getThumbnailURL();
    }
}
