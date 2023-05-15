package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.example.clonepjtairbb.stay.dto.ReservationRequest;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Calendar;

public interface StayReservationRepositoryCustom {
    Boolean existsOverlappingPreviousReservation(Calendar checkinDate, Calendar checkoutDate);
}
