package com.example.clonepjtairbb.stay.repository.QueryDSL;

import java.util.Calendar;

public class StayReservationRepositoryImpl implements StayReservationRepositoryCustom{


    @Override
    public Boolean existsOverlappingPreviousReservation(Calendar checkinDate, Calendar checkoutDate) {
        return null;
    }
}
