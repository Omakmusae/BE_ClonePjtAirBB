package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.example.clonepjtairbb.stay.entity.Stay;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class StayRepositoryImpl implements StayRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
}
