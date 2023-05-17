package com.example.clonepjtairbb.common.enums;

public enum DescTagEnum {
    ATTRACTIVE("매력적인"),
    HIP("힙한"),
    SOPHITICATED("우아한"),
    CITYHEART("도시중심"),
    UNIQUE("특별한");

    private final String description;
    DescTagEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static DescTagEnum fromString(String description) {
        for (DescTagEnum descTagEnum : DescTagEnum.values()) {
            if (descTagEnum.getDescription().equalsIgnoreCase(description)) {
                return descTagEnum;
            }
        }
        return null;
    }


}
