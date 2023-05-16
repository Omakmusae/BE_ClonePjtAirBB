package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@RequiredArgsConstructor
@Repository
public class StayReservationRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    public Boolean findOverlappingPreviousReservation(Calendar checkinDate, Calendar checkoutDate) {
        return null;
    }


    private BooleanExpression checkinDateBetween(Calendar checkinRequest, Calendar checkoutRequest){
        return null;
    }

}
