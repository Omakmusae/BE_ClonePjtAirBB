package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.example.clonepjtairbb.common.enums.*;
import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.clonepjtairbb.stay.entity.QStay.stay;
import static com.example.clonepjtairbb.stay.entity.QStayDetailFeature.stayDetailFeature;

@RequiredArgsConstructor
@Repository
public class StayRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    public List<Stay> findBySearchOption(SearchOptionRequest request) {
//        Integer cost = (Integer) request.getData().get("costPerDay");           // 숙박비
//        String country = (String) request.getData().get("country");             // 나라
//        String city = (String) request.getData().get("city");                   // 도시
//        String stayType = (String) request.getData().get("stayType");           // 숙박 타입(주택, 캠핑카, 아파트 ..)
//        Integer numBed = (Integer) request.getData().get("numBed");             // 침대갯수
//        String bedType = (String) request.getData().get("bedType");             // 침대 타입
////        boolean isAlone = (boolean) request.getData().get("isAlone");           // 숙박 시설 쉐어 여부
//        String descTag = (String) request.getData().get("descTag");             // 숙박 시설 태그
//        Integer maxGroupNum = (Integer) request.getData().get("maxGroupNum");   // 최대 게스트 수
         String city = request.getCity();                   // 도시
         String country = request.getCountry();             // 나라
         String stayType = request.getStayType();           // 주거 형식
         Integer min = request.getMinCost();                // 최소값
         Integer max = request.getMaxCost();                // 최대값
//        return jpaQueryFactory
//                .select(stay)
//                .from(stay)
//                .where()

        return  jpaQueryFactory
                .select(stay)
                .from(stay)
                .where(eqCity(city),
                        eqCountry(country),
                        eqCostPerDay(min, max),
                        eqStayType(stayType))
                .fetch();
    }


    // 숙박비
    private BooleanExpression eqCostPerDay(Integer minCost, Integer maxCost){
        if(minCost == null && maxCost == null) return null;
        return stay.costPerDay.between(minCost, maxCost);
    }
    // 나라
    private BooleanExpression eqCountry(String country){
        return (country == null || country.isEmpty()) ? null : stay.country.eq(CountryEnum.valueOf(country));
    }
    // 도시
    private BooleanExpression eqCity(String city){
        return (city == null || city.isEmpty()) ? null : stay.city.eq(CityEnum.valueOf(city));
    }
    // 숙박 형태
    private BooleanExpression eqStayType(String stayType){
        return (stayType == null || stayType.isEmpty()) ? null : stay.stayType.eq(StayTypeEnum.valueOf(stayType));
    }
    private BooleanExpression eqBedType(String bedType){
        return (bedType == null || bedType.isEmpty()) ? null : stayDetailFeature.bedType.eq(BedTypeEnum.valueOf(bedType));
    }
    private BooleanExpression eqNumBed(Integer numBed){
        return numBed == null ? null : stayDetailFeature.numBed.eq(numBed);
    }
    private BooleanExpression eqDescTag(String descTag){
        return (descTag == null || descTag.isEmpty()) ? null : stayDetailFeature.descTag.eq(DescTagEnum.valueOf(descTag));
    }
    private BooleanExpression eqMaxGroupNum(Integer maxGroupNum) {
        return (maxGroupNum == null) ? null : stayDetailFeature.maxGroupNum.eq(maxGroupNum);
    }
}
