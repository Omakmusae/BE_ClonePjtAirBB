package com.example.clonepjtairbb.common.enums;

public enum CountryEnum {
    KOREA("한국"),
    JAPAN("일본");


    private final String countryName;

    CountryEnum(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public static CountryEnum fromString(String countryName) {
        for (CountryEnum country : CountryEnum.values()) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }
}
