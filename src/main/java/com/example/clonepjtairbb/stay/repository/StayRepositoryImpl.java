package com.example.clonepjtairbb.stay.repository;
import static com.example.clonepjtairbb.stay.entity.QStay.stay;
import static com.example.clonepjtairbb.stay.entity.QStayDetailFeature.stayDetailFeature;

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

@Repository
public class StayRepositoryImpl implements StayRepository{

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

	@Override
	public <S extends Stay> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Stay> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<Stay> findById(Long aLong) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}

	@Override
	public List<Stay> findAll() {
		return null;
	}

	@Override
	public List<Stay> findAllById(Iterable<Long> longs) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long aLong) {

	}

	@Override
	public void delete(Stay entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> longs) {

	}

	@Override
	public void deleteAll(Iterable<? extends Stay> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public void flush() {

	}

	@Override
	public <S extends Stay> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public <S extends Stay> List<S> saveAllAndFlush(Iterable<S> entities) {
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Stay> entities) {

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> longs) {

	}

	@Override
	public void deleteAllInBatch() {

	}

	@Override
	public Stay getOne(Long aLong) {
		return null;
	}

	@Override
	public Stay getById(Long aLong) {
		return null;
	}

	@Override
	public Stay getReferenceById(Long aLong) {
		return null;
	}

	@Override
	public <S extends Stay> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends Stay> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Stay> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public <S extends Stay> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Stay> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Stay> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public <S extends Stay, R> R findBy(Example<S> example,
		Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	public List<Stay> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<Stay> findAll(Pageable pageable) {
		return null;
	}
}
