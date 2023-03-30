package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;

import com.spring.api.domain.LectureClass;
import com.spring.api.request.LectureClassSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;
import static com.spring.api.domain.QLectureClass.lectureClass;

@RequiredArgsConstructor
public class LectureClassRepositoryImpl implements LectureClassRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<LectureClass> getList(LectureClassSearch lectureClassSearch) {
        return jpaQueryFactory.selectFrom(lectureClass)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(lectureClass.lecture.id.desc())
                .fetch();
    }
}
