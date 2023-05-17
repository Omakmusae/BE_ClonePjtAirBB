package com.example.clonepjtairbb.common.enums;

public enum CityEnum {
    SEOUL("서울"),
    BUSAN("부산"),
    DAEJUN("대전"),
    GWANGJU("광주"),
    TOKYO("도쿄"),
    OSAKA("오사카");

    private final String city;

    CityEnum(String stringType) {
        this.city = stringType;
    }

    public String getCity() {
        return city;
    }

    public static CityEnum fromString(String city) {
        for (CityEnum cityEnum : CityEnum.values()) {
            if (cityEnum.getCity().equalsIgnoreCase(city)) {
                return cityEnum;
            }
        }
        return null;
    }

}
