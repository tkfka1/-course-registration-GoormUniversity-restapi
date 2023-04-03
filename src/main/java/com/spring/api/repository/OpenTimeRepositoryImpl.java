package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.OpenTime;
import com.spring.api.request.OpenTimeSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QOpenTime.openTime;

@RequiredArgsConstructor
public class OpenTimeRepositoryImpl implements OpenTimeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<OpenTime> getList(OpenTimeSearch openTimeSearch) {
        return jpaQueryFactory.selectFrom(openTime)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(openTime.id.asc())
                .fetch();
    }
}
