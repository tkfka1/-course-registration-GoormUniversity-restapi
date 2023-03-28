package com.spring.api.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.TakeLecture;
import com.spring.api.request.TakeLectureSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QTakeLecture.takeLecture;

@RequiredArgsConstructor
public class TakeLectureRepositoryImpl implements TakeLectureRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TakeLecture> getList(TakeLectureSearch takelectureSearch) {
        return jpaQueryFactory.selectFrom(takeLecture)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(takeLecture.id.desc())
                .fetch();
    }
}
