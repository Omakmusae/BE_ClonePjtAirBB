package com.example.clonepjtairbb.stay.repository.QueryDSL;


import com.example.clonepjtairbb.common.enums.*;
import com.example.clonepjtairbb.stay.dto.MappedSearchRequest;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

import static com.example.clonepjtairbb.stay.entity.QStay.stay;
import static com.example.clonepjtairbb.stay.entity.QStayReservation.stayReservation;


@Repository
@RequiredArgsConstructor
public class StayRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    public List<Stay> findBySearchOption(MappedSearchRequest request) {

        return  jpaQueryFactory
                .select(stay)
                .from(stay)
                .leftJoin(stayReservation)
                .where(
                        eqCountry(request.getCountry()),
                        eqCity(request.getCity()),
                        hasNoOverlappingPreviousReservation(request.getCheckin_date(),request.getCheckout_date()),
                        goeGroupsize(request.getGroupsize()),
                        eqStayType(request.getStayType()),
                        goeCostPerDay(request.getCost_min()),
                        loeCostPerDay(request.getCost_max()),
//
//                        /////////////여기까지 기본필터////////////////////
                        goeNumBed(request.getNumBed()),
                        eqBedType(request.getBedType()),
                        eqIsShared(request.getIsShared()),
                        eqDescTag(request.getDescTag())

                )
                .fetch();
    }

    // 나라
    private BooleanExpression eqCountry(CountryEnum country){
        return country == null ? null : stay.country.eq(country);
    }
    //
        // 도시
        private BooleanExpression eqCity(CityEnum city){
            return city == null ? null : stay.city.eq(city);
        }
    //
    //    //checkin, checkout 날짜 필터는 StayReservationRepositoryCustom에 있는 checkReservationOkay로 대체하겠습니다

    // 숙박비
    private BooleanExpression goeGroupsize(Integer groupSize){
        return groupSize == null ? null : stay.stayDetailFeature.maxGroupNum.goe(groupSize);
    }
    // 숙박 형태
    private BooleanExpression eqStayType(StayTypeEnum stayType){
        return stayType == null ? null : stay.stayType.eq(stayType);
    }

    //가격
    private BooleanExpression goeCostPerDay(Integer minCost){
        return minCost == null ? null : stay.costPerDay.goe(minCost);
    }
    private BooleanExpression loeCostPerDay(Integer maxCost){
        return maxCost == null ? null : stay.costPerDay.loe(maxCost);
    }

    //침대 수
    private BooleanExpression goeNumBed(Integer numBed){
        return numBed == null ? null : stay.stayDetailFeature.numBed.goe(numBed);
    }
    //침대 종류
    private BooleanExpression eqBedType(BedTypeEnum bedType){
        return bedType == null ? null : stay.stayDetailFeature.bedType.eq(bedType);
    }

    private BooleanExpression eqIsShared(Boolean isShared){
        return isShared == null ? null : stay.stayDetailFeature.isAlone.eq(true);
    }
    //설명 요약 태그
    private BooleanExpression eqDescTag(DescTagEnum descTag){
        return descTag == null ? null : stay.stayDetailFeature.descTag.eq(descTag);
    }



    ////////////////여기는 숙소 예약 가능여부 필터 ///////////////////////////////////
    private BooleanExpression checkinDateAfterRequestCheckout(Calendar checkoutRequest){
        return checkoutRequest == null ? null : stayReservation.checkinDate.after(checkoutRequest);
    }
    private BooleanExpression checkoutDateBeforeRequestCheckin(Calendar checkinRequest) {
        return checkinRequest == null ? null : stayReservation.checkoutDate.before(checkinRequest);
    }
    private BooleanExpression checkReservationOkay(Calendar checkinRequest, Calendar checkoutRequest){
        if (checkinRequest == null || checkoutRequest == null) {return null;}
        return checkinDateAfterRequestCheckout(checkoutRequest)
                .or(checkoutDateBeforeRequestCheckin(checkinRequest));
    }

    public BooleanExpression hasNoOverlappingPreviousReservation(Calendar checkinRequest, Calendar checkoutRequest) {
        if (checkinRequest == null || checkoutRequest == null) {return null;}
        return jpaQueryFactory
                .select(stay)
                .from(stayReservation)
                .where(
                        stayReservation.stay.eq(stay),
                        checkReservationOkay(
                                checkinRequest, checkoutRequest
                        ).not()
                )
                .exists().not();
    }
    ////////////////↑↑↑↑↑↑↑↑ 숙소 예약 가능여부 필터 ///////////////////////////////////

}
