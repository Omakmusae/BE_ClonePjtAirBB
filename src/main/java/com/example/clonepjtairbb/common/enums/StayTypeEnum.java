package com.example.clonepjtairbb.common.enums;

public enum StayTypeEnum {
    ROOM("원룸"),
    HANOK("한옥"),
    POOLVILLA("풀빌라"),
    CASTLE("성"),
    CAMPING("캠핑"),
    CABIN("산장"),
    FARM("농장"),
    RYOKAN("료칸"),
    BOAT("보트");

    private final String stayType;
    StayTypeEnum(String stayType) {
        this.stayType = stayType;
    }

    public String getStayType() {
        return stayType;
    }

    public static StayTypeEnum fromString(String stayType) {
        for (StayTypeEnum stayTypeEnum : StayTypeEnum.values()) {
            if (stayTypeEnum.getStayType().equalsIgnoreCase(stayType)) {
                return stayTypeEnum;
            }
        }
        return null;
    }
}
