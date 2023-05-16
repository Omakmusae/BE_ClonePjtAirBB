package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.common.enums.CityEnum;
import com.example.clonepjtairbb.common.enums.CountryEnum;
import com.example.clonepjtairbb.common.enums.StayTypeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StaySearchRequest {

	private String title;
	private String content;
	private String thumbnailURL;
	private CountryEnum country;
	private CityEnum city;
	private Integer costPerDay;
	private StayTypeEnum stayType;




}
