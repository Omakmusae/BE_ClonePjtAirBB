package com.example.clonepjtairbb.stay.repository.QueryDSL;

import static com.example.clonepjtairbb.stay.entity.QStay.*;
import static com.example.clonepjtairbb.stay.entity.QStayDetailFeature.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import com.example.clonepjtairbb.TestConfig;
import com.example.clonepjtairbb.common.enums.BedTypeEnum;
import com.example.clonepjtairbb.common.enums.CityEnum;
import com.example.clonepjtairbb.common.enums.ConvenienceEnum;
import com.example.clonepjtairbb.common.enums.CountryEnum;
import com.example.clonepjtairbb.common.enums.DescTagEnum;
import com.example.clonepjtairbb.common.enums.StayTypeEnum;
import com.example.clonepjtairbb.stay.dto.MappedSearchRequest;
import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
import com.example.clonepjtairbb.stay.entity.QStay;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.example.clonepjtairbb.stay.entity.QStay.stay;
import jakarta.persistence.EntityManager;


@TestPropertySource(locations = "/application.properties")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({TestConfig.class})
class StayRepositoryCustomTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private StayRepositoryCustom testRepository;

	@Test
	void findBySearchOption() {
		//given

		CountryEnum country = null;             // 나라
		CityEnum city = null;                // 도시
		Integer cost_min = 10000;            // 최소값
		Integer cost_max= null;;            // 최댓값
		StayTypeEnum stayType= null;;            // 주거형식

		// Details
		Integer numBed= null;;             // 침대갯수
		BedTypeEnum bedType= null;;        // 침대타입
		Boolean isShared= null;;            // 쉐어여부
		DescTagEnum descTag= null;;        // 숙소에 대한 설명 태그
		Calendar checkin_date= null;;        //체크인 요청 날짜
		Calendar checkout_date= null;;       //체크아웃 요청 날짜
		Integer groupsize= null;;        // 숙박 인원수
		List<String> convenience= null;;

		System.out.println("테스트를 위해 필터 조건을 입력해주세요");
		MappedSearchRequest searchRequest = MappedSearchRequest.builder()
			.country(country)
			.city(city)
			.cost_min(cost_min)
			.cost_max(cost_max)
			.stayType(stayType)
			.numBed(numBed)
			.bedType(bedType)
			.isShared(isShared)
			.descTag(descTag)
			.checkin_date(checkin_date)
			.checkout_date(checkout_date)
			.groupsize(groupsize)
			.convenience(convenience)
			.build();

		List<Stay> result = testRepository.findBySearchOption(searchRequest);

		for (Stay stay : result) {
			System.out.println("stay.getTitle() = " + stay.getTitle());
			System.out.println("stay.toString() = " + stay.getContent());
		}

	}
}