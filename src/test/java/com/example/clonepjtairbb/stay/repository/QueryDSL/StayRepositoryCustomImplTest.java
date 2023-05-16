package com.example.clonepjtairbb.stay.repository.QueryDSL;

import static com.example.clonepjtairbb.common.enums.CityEnum.*;
import static com.example.clonepjtairbb.common.enums.CountryEnum.*;
import static com.example.clonepjtairbb.common.enums.StayTypeEnum.*;

import com.example.clonepjtairbb.common.enums.*;
import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
import com.example.clonepjtairbb.stay.entity.QStay;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.user.entity.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;

import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import(StayRepositoryCustomImpl.class)
class StayRepositoryCustomImplTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private JPAQueryFactory jpaQueryFactory;

	@Autowired
	private StayRepositoryCustomImpl stayRepositoryCustomImpl;








}