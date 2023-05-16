package com.example.clonepjtairbb.stay.repository.QueryDSL;

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

import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
import com.example.clonepjtairbb.stay.entity.Stay;

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
		Integer cost = null;           // 숙박비
		String country = "";             // 나라
		String city = "";                   // 도시
		String stayType = "";           // 숙박 타입(주택, 캠핑카, 아파트 ..)
		Integer numBed = null;             // 침대갯수
		String bedType = "";             // 침대 타입
		String descTag = "";             // 숙박 시설 태그
		Integer maxGroupNum = null;   // 최대 게스트 수

		Map<String, Object> data = new HashMap<>();
		data.put("costPerDay", cost);
		data.put("country", country);
		data.put("city", city);
		data.put("stayType", stayType);
		data.put("numBed", numBed);
		data.put("bedType", bedType);
		data.put("descTag", descTag);
		data.put("maxGroupNum", maxGroupNum);

		System.out.println("테스트");
		SearchOptionRequest request = new SearchOptionRequest(data);

		List<Stay> result = testRepository.findBySearchOption(request);

		for (Stay stay : result) {
			System.out.println("stay.getTitle() = " + stay.getTitle());
			System.out.println("stay.toString() = " + stay.getContent());
		}

	}
}