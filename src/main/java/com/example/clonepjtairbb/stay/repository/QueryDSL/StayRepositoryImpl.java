package com.example.clonepjtairbb.stay.repository.QueryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.example.clonepjtairbb.stay.entity.QStay.stay;


@Repository
@RequiredArgsConstructor
public class StayRepositoryImpl implements StayRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
}
