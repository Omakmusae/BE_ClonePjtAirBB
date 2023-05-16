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
		System.out.println("테스트를 위해 필터 조건을 입력해주세요");
		MappedSearchRequest searchRequest = MappedSearchRequest.builder()
			.country(CountryEnum.KOREA)
			.city(CityEnum.SEOUL)
			.cost_min(100)
			.cost_max(500)
			.stayType(StayTypeEnum.ROOM)
			.numBed(2)
			.bedType(BedTypeEnum.DOUBLE)
			.isShared(false)
			.descTag(DescTagEnum.ATTRACTIVE)     // Set the description tag
			.checkin_date(Calendar.getInstance())
			.checkout_date(Calendar.getInstance())
			.groupsize(4)
			.convenience(Arrays.asList(ConvenienceEnum.WIFI, ConvenienceEnum.WIFI))  // Set the list of conveniences
			.build();
		
		List<Stay> result = testRepository.findBySearchOption(searchRequest);

		for (Stay stay : result) {
			System.out.println("stay.getTitle() = " + stay.getTitle());
			System.out.println("stay.toString() = " + stay.getContent());
		}

	}
}