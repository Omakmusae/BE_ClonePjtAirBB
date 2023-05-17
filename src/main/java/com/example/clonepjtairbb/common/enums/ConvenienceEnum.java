package com.example.clonepjtairbb.common.enums;

public enum ConvenienceEnum {
    WIFI("와이파이"),                   // 무선인터넷
    TV("TV"),                     // TV
    KITCHEN("주방"),                // 주방
    WASHER("세탁기"),                 // 세탁기
    PARKINGLOT("주차장"),             // 주차공간
    AIRCONDITIONER("에어컨"),         // 에어컨
    SWIMMINGPOOL("수영장"),           // 수영장
    BBQGRILL("바베큐"),               // 야외바비큐그릴
    SPORTEQUIPMENT("운동기구"),         // 운동기구
    FIRSTAIDKIT("구급상자"),            // 구급상자
    FIREEXTINGUISHER("소화기");        // 소화기

    private final String convenience;

    ConvenienceEnum(String convenience) {
        this.convenience = convenience;
    }

    public String getConvenience() {
        return convenience;
    }

    public static ConvenienceEnum fromString(String convenience) {
        for (ConvenienceEnum convenienceEnum : ConvenienceEnum.values()) {
            if (convenienceEnum.getConvenience().equalsIgnoreCase(convenience)) {
                return convenienceEnum;
            }
        }
        return null;
    }
}
