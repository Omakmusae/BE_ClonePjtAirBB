package com.example.clonepjtairbb.stay.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;


import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.example.clonepjtairbb.stay.entity.QStay.stay;

@Repository
public class StayRepositoryImpl implements StayRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public StayRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	public List<Stay> findAllInnerFetchJoinWithDistinct() {
		return jpaQueryFactory.selectFrom(stay)
				// .innerJoin(stayDetailFeature)
				// .on(stay.stay_id = stayDetailFeature.stay_id)
				// .fetchJoin()
				.fetch();
	}
}
