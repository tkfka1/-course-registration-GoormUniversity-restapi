package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.Major;
import com.spring.api.request.MajorSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QMajor.major;

@RequiredArgsConstructor
public class MajorRepositoryImpl implements MajorRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Major> getList(MajorSearch majorSearch) {
        return jpaQueryFactory.selectFrom(major)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(major.id.desc())
                .fetch();
    }
}
