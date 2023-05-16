package com.example.clonepjtairbb.stay.dto;

import com.example.clonepjtairbb.stay.entity.StayReservation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Getter
public class BookedDateListResponse {
    private final String startDate;

    private final String endDate;

    public BookedDateListResponse(StayReservation reservation) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.format(reservation.getCheckinDate().getTime());
        this.endDate = sdf.format(reservation.getCheckoutDate().getTime());
    }
}
