package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;

import com.spring.api.domain.User;
import com.spring.api.request.UserSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getList(UserSearch userSearch) {
        return jpaQueryFactory.selectFrom(user)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(user.id.desc())
                .fetch();
    }
}
