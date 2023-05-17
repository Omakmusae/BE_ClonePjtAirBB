package com.example.clonepjtairbb.common.enums;

public enum BathTypeEnum {
    PRIVATE("단독샤워"),
    SHARED("공용샤워");

    private final String bathType;

    BathTypeEnum(String bathType) {
        this.bathType = bathType;
    }

    public String getBathType() {
        return bathType;
    }

    public static BathTypeEnum fromString(String bathType) {
        for (BathTypeEnum bathTypeEnum : BathTypeEnum.values()) {
            if (bathTypeEnum.getBathType().equalsIgnoreCase(bathType)) {
                return bathTypeEnum;
            }
        }
        return null;
    }
}
