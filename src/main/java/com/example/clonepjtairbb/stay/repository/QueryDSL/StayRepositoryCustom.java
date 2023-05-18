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
                        eqDescTag(request.getDescTag()),
                        ////편의시설/////
                        hasWIFI(request.getConvenience()),
                        hasTV(request.getConvenience()),
                        hasKITCHEN(request.getConvenience()),
                        hasWASHER(request.getConvenience()),
                        hasPARKINGLOT(request.getConvenience()),
                        hasAIRCONDITION(request.getConvenience()),
                        hasSWIMMINGPOOL(request.getConvenience()),
                        hasBBQGRILL(request.getConvenience()),
                        hasSPORTEQUIPMENT(request.getConvenience()),
                        hasFIRSTAID(request.getConvenience()),
                        hasFIREEXTINGUISHER(request.getConvenience())
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
    //편의시설 필터들
    private BooleanExpression hasWIFI(List<String> reqConv){
        return reqConv == null || !reqConv.contains("와이파이") ? null : stay.stayDetailFeature.hasWIFI.eq(true);
    }
    private BooleanExpression hasTV(List<String> reqConv){
        return reqConv == null || !reqConv.contains("TV") ? null : stay.stayDetailFeature.hasTV.eq(true);
    }
    private BooleanExpression hasKITCHEN(List<String> reqConv){
        return reqConv == null || !reqConv.contains("주방") ? null : stay.stayDetailFeature.hasKITCHEN.eq(true);
    }
    private BooleanExpression hasWASHER(List<String> reqConv){
        return reqConv == null || !reqConv.contains("세탁기") ? null : stay.stayDetailFeature.hasWASHER.eq(true);
    }
    private BooleanExpression hasPARKINGLOT(List<String> reqConv){
        return reqConv == null || !reqConv.contains("주차장") ? null : stay.stayDetailFeature.hasPARKINGLOT.eq(true);
    }
    private BooleanExpression hasAIRCONDITION(List<String> reqConv){
        return reqConv == null || !reqConv.contains("에어컨") ? null : stay.stayDetailFeature.hasAIRCONDITION.eq(true);
    }
    private BooleanExpression hasSWIMMINGPOOL(List<String> reqConv){
        return reqConv == null || !reqConv.contains("수영장") ? null : stay.stayDetailFeature.hasSWIMMINGPOOL.eq(true);
    }
    private BooleanExpression hasBBQGRILL(List<String> reqConv){
        return reqConv == null || !reqConv.contains("바베큐") ? null : stay.stayDetailFeature.hasBBQGRILL.eq(true);
    }
    private BooleanExpression hasSPORTEQUIPMENT(List<String> reqConv){
        return reqConv == null || !reqConv.contains("운동기구") ? null : stay.stayDetailFeature.hasSPORTEQUIPMENT.eq(true);
    }
    private BooleanExpression hasFIRSTAID(List<String> reqConv){
        return reqConv == null || !reqConv.contains("구급상자") ? null : stay.stayDetailFeature.hasFIRSTAID.eq(true);
    }
    private BooleanExpression hasFIREEXTINGUISHER(List<String> reqConv){
        return reqConv == null || !reqConv.contains("소화기") ? null : stay.stayDetailFeature.hasFIREEXTINGUISHER.eq(true);
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
