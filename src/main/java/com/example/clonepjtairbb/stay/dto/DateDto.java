package com.example.clonepjtairbb.stay.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Getter
@NoArgsConstructor
public class DateDto {
    private Integer year;
    private Integer month;
    private Integer day;


    public Calendar toCalendar(){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month-1);    //Calendar 에서 1월 = 0 부터 시작
        date.set(Calendar.DAY_OF_MONTH, day);
        return date;
    }
}
