package com.spring.api.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.CartLecture;

import com.spring.api.request.CartLectureSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QCartLecture.cartLecture;

@RequiredArgsConstructor
public class CartLectureRepositoryImpl implements CartLectureRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CartLecture> getList(CartLectureSearch cartlectureSearch) {
        return jpaQueryFactory.selectFrom(cartLecture)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(cartLecture.id.desc())
                .fetch();
    }
}
