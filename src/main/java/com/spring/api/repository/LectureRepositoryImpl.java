package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.Lecture;
import com.spring.api.request.LectureSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QLecture.lecture;

@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Lecture> getList(LectureSearch lectureSearch) {
        return jpaQueryFactory.selectFrom(lecture)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(lecture.id.desc())
                .fetch();
    }
}
