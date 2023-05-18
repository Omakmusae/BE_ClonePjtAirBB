package com.example.clonepjtairbb.stay.dto;


import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.entity.StayReservation;
import com.example.clonepjtairbb.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Getter
@NoArgsConstructor
public class ReservationRequest {
    private String checkinDate;
    private String checkoutDate;
    private Integer groupSize;

    public StayReservation toStayReservationEntity(User user, Stay stay) {
        return new StayReservation(
                user, stay, checkinAsCalendar(), checkoutAsCalendar(), groupSize
        );
    }

    public Calendar checkinAsCalendar(){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, Integer.parseInt(this.checkinDate.split("-")[0]));
        date.set(Calendar.MONTH, Integer.parseInt(this.checkinDate.split("-")[1])-1);    //Calendar 에서 1월 = 0 부터 시작
        date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.checkinDate.split("-")[2]));
        return date;
    }
    public Calendar checkoutAsCalendar(){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, Integer.parseInt(this.checkoutDate.split("-")[0]));
        date.set(Calendar.MONTH, Integer.parseInt(this.checkoutDate.split("-")[1])-1);    //Calendar 에서 1월 = 0 부터 시작
        date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.checkoutDate.split("-")[2]));
        return date;
    }
}
