package com.example.clonepjtairbb.stay.repository.QueryDSL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class StayCustomRepository {

	private final JPAQueryFactory queryFactory;

	// public List<Stay> searchByBuilder() {
	// 	return queryFactory
	// 		.from(
	//
	// 		)
	// 		.fetch();
	// }
}