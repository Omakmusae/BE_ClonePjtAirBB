// package com.example.clonepjtairbb.stay.repository.QueryDSL;
//
// import java.util.List;
//
// import org.springframework.stereotype.Repository;
//
//
// import com.example.clonepjtairbb.stay.entity.Stay;
// import com.querydsl.jpa.impl.JPAQueryFactory;
//
// import static com.example.clonepjtairbb.stay.entity.QStay.stay;
//
// @Repository
// public class StayRepositoryImpl implements StayRepositoryCustom{
//
// 	private final JPAQueryFactory jpaQueryFactory;
//
// 	public StayRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
// 		this.jpaQueryFactory = jpaQueryFactory;
// 	}
//
// 	public List<Stay> searchByBuilder() {
// 		return jpaQueryFactory.selectFrom(stay)
// 				// .innerJoin(stayDetailFeature)
// 				// .on(stay.stay_id = stayDetailFeature.stay_id)
// 				// .fetchJoin()
// 				.fetch();
// 	}
//
// }
