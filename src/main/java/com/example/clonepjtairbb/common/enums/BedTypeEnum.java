package com.example.clonepjtairbb.common.enums;

public enum BedTypeEnum {
    SINGLE("싱글"),
    DOUBLE("더블"),
    SUPERSINGLE("슈퍼싱글"),
    QUEEN("퀸"),
    KING("킹");

    private final String bedType;

    BedTypeEnum(String stringType) {
        this.bedType = stringType;
    }

    public String getBedType() {
        return bedType;
    }

    public static BedTypeEnum fromString(String bedType) {
        for (BedTypeEnum bedTypeEnum : BedTypeEnum.values()) {
            if (bedTypeEnum.getBedType().equalsIgnoreCase(bedType)) {
                return bedTypeEnum;
            }
        }
        return null;
    }
}
